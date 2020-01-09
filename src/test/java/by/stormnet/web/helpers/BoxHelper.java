package by.stormnet.web.helpers;

import by.stormnet.web.pages.BoxPage;

public class BoxHelper extends AbsractHelper {
    BoxPage onBP = new BoxPage();

    public int resultsNumber() {
        return onBP.resultsNumber();
    }

    public boolean checkElements() {
        if (onBP.checkPhone()
                && onBP.checkLocation()
                && onBP.checkEmail()
                && onBP.checkComment()
                && onBP.checkArea()) {
            return true;
        } else {
            return false;
        }
    }
}
