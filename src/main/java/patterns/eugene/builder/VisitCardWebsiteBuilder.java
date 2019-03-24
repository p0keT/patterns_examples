package patterns.eugene.builder;

public class VisitCardWebsiteBuilder extends WebsiteBuilder{
    void buildName() {
        website.setName("Visit card");
    }

    void buildCms() {
        website.setCms(Cms.WORDPRESS);
    }

    void buildPrice() {
        website.setPrice(500);
    }
}
