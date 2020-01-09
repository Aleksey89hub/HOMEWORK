package by.stormnet.web.helpers;

import by.stormnet.web.pages.OnlinerMainPage;

public class OnlinerMainHelper extends AbsractHelper {
    OnlinerMainPage onMP = new OnlinerMainPage();

    public OnlinerMainHelper openOnliner() {
        System.out.println("Navigate to Onliner page ...");
        onMP.navigateToMainPage();
        return this;
    }

    public OnlinerMainHelper openNews() {
        System.out.println("Open news from Technology section");
        onMP.clickNewsLink();
        return this;
    }

    public void search(String str) {
        System.out.println("Search by " + str);
        onMP.search();
    }
}
