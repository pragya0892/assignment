package dataproviders;

import utils.ExcelReadUtils;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UriComparisonDP {

    /**
     * Running data provider parallel so that it takes very less time.
     * Just try to run without parallel mode and it will take around 50-60 minutes to hit 2k requests.
     * As mentioned in the assignment about the memory issue which i am not facing here
     * */

    @DataProvider(name = "UriComparisonDP",parallel = true)
    public static Iterator<Object[]> getUrls() throws Exception
    {
        ExcelReadUtils excelReadUtils =  new ExcelReadUtils();

        List<Object[]> listOfUrls = new ArrayList<Object[]>();

        List<String> urlListFromFile1 = excelReadUtils.getUriFromExcelFile("./src/main/resources/File1.xlsx");
        List<String> urlListFromFile2 = excelReadUtils.getUriFromExcelFile("./src/main/resources/File2.xlsx");

        int arrayLength = urlListFromFile1.size();

        for (int i=0;i<arrayLength;i++) {

            listOfUrls.add(new Object[]{urlListFromFile1.get(i),urlListFromFile2.get(i)});
        }

        return listOfUrls.iterator();

    }
}
