package by.stormnet.web.helpers;

import by.stormnet.web.pages.GoodsPage;

public class GoodsHelper extends AbsractHelper {
    private GoodsPage onGP = new GoodsPage();

    public boolean checkElements() {
        if (onGP.checkDesc() &&
                onGP.checkPrice() &&
                onGP.checkCom() &&
                onGP.checkBtn()) {
            return true;
        } else {
            return false;
        }
    }

    public int getInitIndex(String init) {
        int a = onGP.getTabsList().indexOf(init);
        return a;
    }

    public void setTabsList() {
        onGP.setTabsList();
    }

    public GoodsHelper navigateToGoodsPage(int num) {
        onGP.navigateToGoodsPage(num);
        return this;
    }

    public void addAll(int n) throws InterruptedException {
        onGP.addAllItems(n);
    }

}
