package com.company;

import com.company.model.*;
import org.w3c.dom.Node;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        root Root = new root();
        Genre genre = new Genre();
        int qtyBooks = 0;
        int qtyPapers = 0;

        Document doc = null;
        try {
            doc = buildDocument();
        } catch (Exception e) {
            System.out.println("Open parsing error " + e.toString());
        }

        Node genreNode = null;

        assert doc != null;
        Node rootNode = doc.getFirstChild();
        NodeList rootChilds = rootNode.getChildNodes();
        List<Genre> genreList = new ArrayList<>();
        List<Science> scienceList = new ArrayList<>();
        List<Art> artList = new ArrayList<>();
        List<Fiction> fictionList = new ArrayList<>();

        for (int i = 0; i < rootChilds.getLength(); i++) {

            if (rootChilds.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            if (rootChilds.item(i).getNodeName().equals("genre")) {
                genreNode = rootChilds.item(i);
            }
        }


        Node scienceNode = null;
        Node artNode = null;
        Node fictionNode = null;

        if (genreNode == null) {
            return;
        }


        NodeList genreChilds = genreNode.getChildNodes();

        for (int j = 0; j < genreChilds.getLength(); j++) {
            if (genreChilds.item(j).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }

            if (genreChilds.item(j).getNodeName().equals("science")) {
                scienceNode = genreChilds.item(j);
                continue;
            }
            if (genreChilds.item(j).getNodeName().equals("art")) {
                artNode = genreChilds.item(j);
                continue;
            }
            if (genreChilds.item(j).getNodeName().equals("fiction")) {
                fictionNode = genreChilds.item(j);
                continue;
            }
        }

        assert scienceNode != null;
        NodeList scienceChild = scienceNode.getChildNodes();

        assert artNode != null;
        NodeList artChild = artNode.getChildNodes();

        assert fictionNode != null;
        NodeList fictionChild = fictionNode.getChildNodes();


        for (int i = 0; i < scienceChild.getLength(); i++) {

            if (scienceChild.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }

            String name = null;
            int pqty = 0;
            int bqty = 0;

            NodeList bookChild = scienceChild.item(i).getChildNodes();
            for(int j = 0; j<bookChild.getLength(); j++){

                if (bookChild.item(j).getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }

                switch (bookChild.item(j).getNodeName()) {
                    case "name":{
                        name = bookChild.item(j).getTextContent();
                        break;
                    }
                    case "pqty":{
                        pqty = Integer.parseInt(bookChild.item(j).getTextContent());
                        break;
                    }
                    case "bqty":{
                        bqty = Integer.parseInt(bookChild.item(j).getTextContent());
                        break;
                    }
                }
            }
            Science science = new Science(name, pqty,bqty);
            scienceList.add(science);
            genre.setScience(scienceList);
        }

        for (int i = 0; i < artChild.getLength(); i++) {

            if (artChild.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }

            String name = null;
            int pqty = 0;
            int bqty = 0;

            NodeList bookChild = artChild.item(i).getChildNodes();
            for(int j = 0; j<bookChild.getLength(); j++){

                if (bookChild.item(j).getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }

                switch (bookChild.item(j).getNodeName()) {
                    case "name":{
                        name = bookChild.item(j).getTextContent();
                        break;
                    }
                    case "pqty":{
                        pqty = Integer.parseInt(bookChild.item(j).getTextContent());
                        break;
                    }
                    case "bqty":{
                        bqty = Integer.parseInt(bookChild.item(j).getTextContent());
                        break;
                    }
                }
            }
            Art art = new Art(name, pqty,bqty);
            artList.add(art);
            genre.setArt(artList);
        }

        for (int i = 0; i < fictionChild.getLength(); i++) {

            if (fictionChild.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }

            String name = null;
            int pqty = 0;
            int bqty = 0;

            NodeList bookChild = fictionChild.item(i).getChildNodes();
            for(int j = 0; j<bookChild.getLength(); j++){

                if (bookChild.item(j).getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }

                switch (bookChild.item(j).getNodeName()) {
                    case "name":{
                        name = bookChild.item(j).getTextContent();
                        break;
                    }
                    case "pqty":{
                        pqty = Integer.parseInt(bookChild.item(j).getTextContent());
                        break;
                    }
                    case "bqty":{
                        bqty = Integer.parseInt(bookChild.item(j).getTextContent());
                        break;
                    }
                }
            }
            Fiction fiction = new Fiction(name, pqty,bqty);
            fictionList.add(fiction);
            genre.setFiction(fictionList);
        }

        List<Science> a = genre.getScience();
        for(int i = 0; i<a.size(); i++){
           qtyBooks += a.get(i).getBqty();
        }
        for(int i = 0; i<a.size(); i++){
            qtyPapers += a.get(i).getPqty();
        }
        qtyPapers = qtyPapers * qtyBooks;

        System.out.println(qtyPapers);
        System.out.println(qtyBooks);

        System.out.println(genre.toString());
    }

    private static Document buildDocument() throws Exception{
        
        File file = new File("test.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        return dbf.newDocumentBuilder().parse(file);
        
        }
    }
