package by.stormnet.web.helpers;

import by.stormnet.web.pages.OnlinerFilterPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class OnlinerFilterHelper extends AbsractHelper {
    OnlinerFilterPage onFP = new OnlinerFilterPage();

    public void filterBy (String[] mas){
        for (int i=0; i<mas.length; i++){
            onFP.tickCheckbox(mas[i]);
        }
    }

    public void openAnyItem(){onFP.openItem();}
}
