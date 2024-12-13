package StepDefinitions;

import Pages.DialogContent;
import Pages.Headers;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebElement;
import java.util.List;

public class _00_DataTable {

    Headers ln = new Headers();
    DialogContent dc = new DialogContent();

    @And("Click on the Element in LeftNav")
    public void clickOnTheElementInLeftNav(DataTable dtLinkler) {
        List<String> listLinkler = dtLinkler.asList(String.class);
        for (int i = 0; i < listLinkler.size(); i++) {
            ln.myClick(ln.getWebElement(listLinkler.get(i)));
        }
    }

    @And("Click on the Element in Dialog")
    public void clickOnTheElementInDialog(DataTable dtButtons) {
        List<String> listButton = dtButtons.asList(String.class);
        for (int i = 0; i < listButton.size(); i++) {
            dc.myClick(dc.getWebElement(listButton.get(i)));
        }
    }

    @And("User send keys in Dialog")
    public void userSendKeysInDialog(DataTable dtKutuVeYazilar) {
        List<List<String>> listKutuVeYazilar = dtKutuVeYazilar.asLists(String.class);
        for (int i = 0; i < listKutuVeYazilar.size(); i++) {
            WebElement kutu = (dc.getWebElement(listKutuVeYazilar.get(i).get(0)));
            dc.mySendKeys(kutu, listKutuVeYazilar.get(i).get(1));
        }
    }

    @And("User send keys in LeftNav")
    public void userSendKeysInLeftNav(DataTable dtKutuVeYazilar) {
        List<List<String>> listKutuVeYazilar = dtKutuVeYazilar.asLists(String.class);
        for (int i = 0; i < listKutuVeYazilar.size(); i++) {
            WebElement kutu = (ln.getWebElement(listKutuVeYazilar.get(i).get(0)));
            ln.mySendKeys(kutu, listKutuVeYazilar.get(i).get(1));
        }
    }


    @And("User select the element from Dialog")
    public void userSelectTheElementFromDialog(DataTable dtSelections) {
        List<List<String>> listSelections = dtSelections.asLists(String.class);
        for (int i = 0; i < listSelections.size(); i++) {
            WebElement ddMenu = dc.getWebElement(listSelections.get(i).get(0));
            dc.mySelectByIndex(ddMenu, Integer.parseInt(listSelections.get(i).get(1)));

        }
    }
}
