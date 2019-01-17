package epam.webParsing.service.parser.parser_xml.parser_gemstone;

import com.epam.webParsing.controller.MainController;
import com.epam.webParsing.entity.entity_interface.XmlEntity;
import com.epam.webParsing.entity.type.EntityType;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.util.List;


public class GemstoneStaxParserTest {
    private static Logger logger = Logger.getLogger(GemstoneStaxParserTest.class.getName());


    @Test
    public void parseTest1() {
        parse("src/main/resources/Gems/Gems.xml");
    }

    @Test
    public void parseTest2() {
        parse("src/main/resources/Gems/Gems2.xml");
    }

    @Test
    public void parseTest3() {
        parse("src/main/resources/Gems/Gems3.xml");

    }

    @Test
    public void parseTest4() {
        parse("src/main/resources/Gems/Gems4.xml");

    }

    @Test
    public void parseTest5() {
        parse("src/main/resources/Gems/Gems5.xml");

    }

    @Test
    public void parseTest6() {
        parse(
                "src/main/resources/Gems/Gems6.xml");
    }

    @Test
    public void parseTest7() {
        parse("src/main/resources/Gems/Gems7.xml");

    }

    @Test
    public void parseTest8() {
        parse("src/main/resources/Gems/Gems8.xml");

    }

    @Test
    public void parseTest9() {
        parse("src/main/resources/Gems/Gems9.xml");

    }

    @Test
    public void parseTest10() {
        parse("src/main/resources/Gems/Gems10.xml");

    }

    @Test
    public void parseTest11() {
        parse(
                "src/main/resources/Gems/Gems11.xml");
    }

    @Test
    public void parseTest12() {
        parse("src/main/resources/Gems/Gems12.xml");

    }

    @Test
    public void parseTest13() {
        parse("src/main/resources/Gems/Gems13.xml");

    }

    @Test
    public void parseTest14() {
        parse("src/main/resources/Gems/Gems14.xml");

    }

    @Test
    public void parseTest15() {
        parse("src/main/resources/Gems/Gems15.xml");

    }

    private void parse(String path) {
        MainController mainController = new MainController();
        List<XmlEntity> list = mainController.readFileAndReturnParsed(path, EntityType.GEMSTONE);
        for (XmlEntity xmlEntity : list) {
            logger.info(xmlEntity.toString());
        }
    }
}
