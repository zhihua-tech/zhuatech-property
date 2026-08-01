/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.property.service;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceSlaService {
    public SlaResult evaluate(SlaRequest request) {
        double consumedRate = Math.round(request.minutesOpen() * 1000.0 / request.resolutionTargetMinutes()) / 10.0;
        int riskScore = Math.min(60, (int) Math.round(consumedRate * 0.6))
            + (request.responseMinutes() > responseTarget(request.priority()) ? 20 : 0)
            + (request.residentVulnerable() ? 10 : 0)
            + (request.repeatedIssue() ? 10 : 0);
        riskScore = Math.min(100, riskScore);
        String status = consumedRate >= 100 ? "BREACHED"
            : consumedRate >= 80 || riskScore >= 70 ? "AT_RISK" : "ON_TRACK";
        List<String> actions = new ArrayList<>();
        if (request.responseMinutes() > responseTarget(request.priority())) actions.add("升级首次响应超时并通知值班主管");
        if (request.residentVulnerable()) actions.add("优先联系并为特殊住户提供替代保障");
        if (request.repeatedIssue()) actions.add("关联历史工单并发起根因分析");
        if (consumedRate >= 80) actions.add("锁定处理资源并持续更新住户进展");
        if (actions.isEmpty()) actions.add("按当前 SLA 节奏跟进并保留服务记录");
        return new SlaResult(consumedRate, riskScore, status, actions);
    }

    private int responseTarget(String priority) {
        return switch (priority) { case "P1" -> 10; case "P2" -> 30; case "P3" -> 120; default -> 240; };
    }

    public record SlaRequest(@NotNull @Pattern(regexp = "P1|P2|P3|P4") String priority,
        @NotNull @Min(0) @Max(1000000) Integer minutesOpen,
        @NotNull @Min(0) @Max(1000000) Integer responseMinutes,
        @NotNull @Positive Integer resolutionTargetMinutes,
        @NotNull Boolean residentVulnerable, @NotNull Boolean repeatedIssue) {}
    public record SlaResult(double consumedRate, int riskScore, String status, List<String> actions) {}
}
