package com.mooveit.cars.tasks;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import java.io.*;
import com.mooveit.cars.domain.*;
import com.mooveit.cars.repositories.*;

@Slf4j
@Service
public class FordIngesterTask {

  /*
  * Model repository to save basic models and submodels
   */
  @Autowired
  private ModelRepository model_repo;

  /*
  * Brand repository to save brand
   */
  @Autowired
  private BrandRepository brand_repo;

  /*
  *
  * Using Java library DOM:
  * Get the Document Builder
  * Get Document
  * Normalize the xml structure
  * Get all the element by the tag name
   */

  @Scheduled(cron = "${cars.ford.ingester.runCron}")
  public void ingestFile() {
    System.out.println("in ingestFile()");
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    try{
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document doc = builder.parse(new File("src/main/resources/ford-example.xml"));
      doc.getDocumentElement().normalize();
      Brand brand = new Brand("Ford");
      brand_repo.save(brand);
      NodeList catalogue = doc.getElementsByTagName("CATALOGUE");
      for(int i=0; i<catalogue.getLength(); i++){
        Node cata = catalogue.item(i);
        Element cataElement = (Element) cata;
        System.out.println("Catalogue name: "+cataElement.getTagName());
        NodeList modelList = cata.getChildNodes();
        for(int j=0; j<modelList.getLength(); j++){
          Node model_node = modelList.item(j);
          if(model_node.getNodeType()==Node.ELEMENT_NODE){
//            Element modelElement = (Element) model;
            Basicmodel bm = this.insertBasic(brand,model_node);
            model_repo.save(bm);
            brand.addModel(bm);

          }
        }
      }

    }catch(ParserConfigurationException e){
      e.printStackTrace();
    } catch (SAXException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  /*
  * Create basic model with it's attributes and child elements
   */
  public Basicmodel insertBasic(Brand brand, Node model_node){
    Element element = (Element) model_node;
    String name = element.getAttribute("name");
    String from = element.getAttribute("from");
    String to = element.getAttribute("to");
    String type = element.getAttribute("type");
    NodeList childList = model_node.getChildNodes();
    Engine engine = new Engine("","");
    Wheel wheel = new Wheel("","");
    /*
    * Get engine and wheel objects
     */
    for(int i=0; i<childList.getLength(); i++){
      Node model_child = childList.item(i);
      System.out.println("in child elements: "+model_child.getNodeName());
      if(model_child.getNodeName()=="ENGINE"){
        System.out.println("in engine child element");
        engine = this.insertEngine(model_child);
      }
      if(model_child.getNodeName()=="WHEELS"){
        System.out.println("in wheel child element");
        wheel = this.insertWheel(model_child);
      }


    }
    Basicmodel model = new Basicmodel(brand,name,from,to,type,engine,wheel);

    /*
    * Get submodel objects and add to ArrayList
     */
    for(int j=0; j<childList.getLength(); j++){
      Node model_child = childList.item(j);
      if(model_child.getNodeName()=="SUBMODELS"){
        System.out.println("inside submodel element");
        NodeList subList = model_child.getChildNodes();
        for(int k=0; k<subList.getLength(); k++){
          System.out.println("getting submodel childs");
          Node sub_node = subList.item(k);
          if(sub_node.getNodeType()==Node.ELEMENT_NODE){
            Submodel submodel = this.insertSub(sub_node);
            model.addSubmodel(submodel);
          }

        }
      }

    }

    return model;
  }

  /*
  * Create submodel object with Engine and Wheel object
   */
  public Submodel insertSub(Node sub_node){
    Element element = (Element) sub_node;
    String name = element.getAttribute("name");
    String from = element.getAttribute("from");
    String to = element.getAttribute("to");
    String line = element.getAttribute("line");
    Engine engine = new Engine("","");
    Wheel wheel = new Wheel("","");
    NodeList childList = sub_node.getChildNodes();
    for(int i=0; i<childList.getLength(); i++){
      Node child_node = childList.item(i);
      if(child_node.getNodeName()=="ENGINE"){
        engine = this.insertEngine(child_node);
      }
      if(child_node.getNodeName()=="WHEELS"){
        wheel = this.insertWheel(child_node);
      }
    }
    return new Submodel(name,from,to,line,engine,wheel);

  }


  /*
  * Create Engine object with attributes
   */
  public Engine insertEngine(Node model_child){
    Element element = (Element) model_child;
    String power = element.getAttribute("power");
    String type = element.getAttribute("type");

    return new Engine(power,type);
  }

  /*
  * Create Wheel object with attributes
   */
  public Wheel insertWheel(Node model_child){
    Element element = (Element) model_child;
    String size = element.getAttribute("size");
    String type = element.getAttribute("type");

    return new Wheel(size,type);

  }

}
