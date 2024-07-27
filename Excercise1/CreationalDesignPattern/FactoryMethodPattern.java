package Excercise1.CreationalDesignPattern;

interface Document {
    void save();
}

class WordDocument implements Document {
    @Override
    public void save() {
        System.out.println("Saving Word document");
    }
}

class PDFDocument implements Document {
    @Override
    public void save() {
        System.out.println("Saving PDF document");
    }
}

abstract class DocumentFactory {
    public abstract Document createDocument();
}

class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}

class PDFDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new PDFDocument();
    }
}

public class FactoryMethodPattern {
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        DocumentFactory pdfFactory = new PDFDocumentFactory();

        Document document1 = wordFactory.createDocument();
        Document document2 = pdfFactory.createDocument();

        document1.save();
        document2.save();
    }
}

