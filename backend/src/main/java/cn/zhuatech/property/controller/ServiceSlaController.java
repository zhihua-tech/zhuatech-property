/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.property.controller;

import cn.zhuatech.property.common.ApiResponse;
import cn.zhuatech.property.service.ServiceSlaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/service-sla")
public class ServiceSlaController {
    private final ServiceSlaService service;
    public ServiceSlaController(ServiceSlaService service) { this.service = service; }
    @PostMapping
    ApiResponse<ServiceSlaService.SlaResult> evaluate(
        @Valid @RequestBody ServiceSlaService.SlaRequest request) {
        return ApiResponse.ok(service.evaluate(request));
    }
}
