/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.property.service;import jakarta.validation.constraints.*;import org.springframework.stereotype.Service;import java.util.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Service public class LeaseRenewalRiskService{/**
                                               * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                               */
public Result evaluate(Request r){int risk=0;List<String> actions=new ArrayList<>();if(r.renewalIntentScore()<50){risk+=35;actions.add("安排租户续约意向访谈");}risk+=Math.min(30,r.openComplaints()*6);if(r.spaceUtilization()<50){risk+=20;actions.add("提供面积调整或灵活空间方案");}if(r.paymentOverdueDays()>0){risk+=25;actions.add("协商清欠与续约付款安排");}if(r.marketRentGapRate()>15){risk+=15;actions.add("复核租金方案与市场竞争力");}if(r.daysToExpiry()<=60)risk+=20;if(r.criticalTenant())risk+=10;risk=Math.min(100,risk);String status=risk>=65?"PRIORITY_RETENTION":risk>=30?"ENGAGE":"STABLE";if(actions.isEmpty())actions.add("租约关系稳定，按常规窗口推进续签");return new Result(risk,status,actions);}
 /**
  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
  */
 public record Request(@Min(0) int daysToExpiry,@Min(0) int openComplaints,@Min(0) @Max(100) int spaceUtilization,@Min(0) int paymentOverdueDays,@DecimalMin("0") double marketRentGapRate,@Min(0) @Max(100) int renewalIntentScore,@NotNull Boolean criticalTenant){}/**
                                                                                                                                                                                                                                                                       * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                       */
public record Result(int churnRisk,String status,List<String> actions){} }
