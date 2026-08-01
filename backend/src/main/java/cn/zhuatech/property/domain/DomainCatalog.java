/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.property.domain;
import org.springframework.stereotype.Component;
import java.util.List;
@Component public class DomainCatalog {
    public String systemName(){return "知华 Property 物业运营管理平台";}
    public String sceneName(){return "园区、楼宇、收费、巡检与报修";}
    public List<SeedItem> seedItems(){return List.of(
        new SeedItem("PROPERTY-20260801-001","A 座客梯停运抢修","处理中","工程维修组","紧急"),
        new SeedItem("PROPERTY-20260801-002","三季度消防联检准备","待处理","安全品质组","高"),
        new SeedItem("PROPERTY-20260801-003","商户水费账单复核","已完成","客户服务组","中"),
        new SeedItem("PROPERTY-20260801-004","地下车库渗水跟进","处理中","项目运营组","高"));}
    public List<String> recommendedActions(){return List.of("优先恢复影响通行与安全的设施","核查超时工单的物料和责任人","复核费用、巡检与客户沟通记录");}
    public record SeedItem(String recordNo,String title,String status,String owner,String priority){}
}
