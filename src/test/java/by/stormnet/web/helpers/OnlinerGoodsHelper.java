package by.stormnet.web.helpers;

import by.stormnet.web.pages.OnlinerGoodsPage;

public class OnlinerGoodsHelper extends AbsractHelper {
    OnlinerGoodsPage onGP = new OnlinerGoodsPage();

     public void checkForPage(){
         onGP.getOnlinerGoodsPage();
     }

    public boolean checkAllParams() {
        if (onGP.checkForProducerFilter() &&
                onGP.checkForYearFilter() &&
                onGP.checkForPurposeFilter() &&
                onGP.checkForResolutionFilter() &&
                onGP.checkForMemoryFilter()) {
            return true;
        } else {
            return false;
        }
    }
}
