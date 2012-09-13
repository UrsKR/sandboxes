package contributionTwo;

import application.BaseModuleForToolBarContributor;
import com.google.inject.Singleton;
import micro.ApplicationContributionModule;

public class ContributionTwoModule extends BaseModuleForToolBarContributor implements ApplicationContributionModule {
    @Override
    protected void configure() {
        contributeToToolBarWith(ContributionTwo.class);
        bind(TwoView.class).to(TwoViewJavaFx.class).in(Singleton.class);
    }
}
