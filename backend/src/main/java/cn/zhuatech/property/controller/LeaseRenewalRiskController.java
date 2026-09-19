/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.property.controller;import cn.zhuatech.property.common.ApiResponse;import cn.zhuatech.property.service.LeaseRenewalRiskService;import jakarta.validation.Valid;import org.springframework.web.bind.annotation.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController @RequestMapping("/api/property/insights/lease-renewal-risk") public class LeaseRenewalRiskController{private final LeaseRenewalRiskService service;/**
                                                                                                                                                                    * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                    */
public LeaseRenewalRiskController(LeaseRenewalRiskService service){this.service=service;}/**
                                                                                                                                                                                                                                                             * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                             */
@PostMapping ApiResponse<LeaseRenewalRiskService.Result> evaluate(@Valid @RequestBody LeaseRenewalRiskService.Request r){return ApiResponse.ok(service.evaluate(r));}}
