/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.property.controller;

import cn.zhuatech.property.common.ApiResponse;
import cn.zhuatech.property.service.ServiceSlaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController
@RequestMapping("/api/admin/service-sla")
public class ServiceSlaController {
    private final ServiceSlaService service;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public ServiceSlaController(ServiceSlaService service) { this.service = service; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping
    ApiResponse<ServiceSlaService.SlaResult> evaluate(
        @Valid @RequestBody ServiceSlaService.SlaRequest request) {
        return ApiResponse.ok(service.evaluate(request));
    }
}
