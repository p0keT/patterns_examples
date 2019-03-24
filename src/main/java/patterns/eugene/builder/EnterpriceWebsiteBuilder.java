package patterns.eugene.builder;

public class EnterpriceWebsiteBuilder extends WebsiteBuilder{
    void buildName() {
        website.setName("Enterprise web site ");
    }

    void buildCms() {
        website.setCms(Cms.ALIFRESCO);
    }

    void buildPrice() {
        website.setPrice(10000);
    }
}
