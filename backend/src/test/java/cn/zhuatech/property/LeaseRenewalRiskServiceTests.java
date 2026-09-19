/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.property;import cn.zhuatech.property.service.LeaseRenewalRiskService;import org.junit.jupiter.api.Test;import static org.junit.jupiter.api.Assertions.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
class LeaseRenewalRiskServiceTests{private final LeaseRenewalRiskService s=new LeaseRenewalRiskService();/**
                                                                                                          * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                          */
@Test void prioritizesAtRiskTenant(){var r=s.evaluate(new LeaseRenewalRiskService.Request(30,5,30,20,20,20,true));assertEquals("PRIORITY_RETENTION",r.status());}/**
                                                                                                                                                                                                                                                                           * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                           */
@Test void keepsStableTenant(){var r=s.evaluate(new LeaseRenewalRiskService.Request(180,0,90,0,3,90,false));assertEquals("STABLE",r.status());}}
