package by.stormnet.web.helpers;

import by.stormnet.web.pages.LamodaMainPage;

public class LamodaMainHelper extends AbsractHelper {
    private LamodaMainPage onLM = new LamodaMainPage();

    public LamodaMainHelper openLamoda() {
        System.out.println("Navigate to Lamoda site ...");
        onLM.navigateToMainPage();
        onLM.setInitHendler();
        return this;
    }

    public LamodaMainHelper search(String data) {
        System.out.println("Search by " + data);
        onLM.searchBy(data);
        return this;
    }

    public int resultsNumber() {
        return onLM.resultsNumber();
    }

    public boolean pageOpen(String page) throws InterruptedException {
        if (page.equals("pagination")) {
            return onLM.openNextPage();
        } else if (page.equals("box")) {
            onLM.openBox();
            return true;
        } else {
            return false;
        }
    }

    public void openGoods() throws InterruptedException {
        System.out.println("Open goods from the list");
        onLM.openGoods();
    }

    public String getInit() {
        return onLM.getInitHendler();
    }
}
