import java.util.Scanner;

interface Document {
    void open();
}

class Report implements Document {
    @Override
    public void open() {
        System.out.println("Открыт документ: Отчет");
    }
}

class Resume implements Document {
    @Override
    public void open() {
        System.out.println("Открыт документ: Резюме");
    }
}

class Letter implements Document {
    @Override
    public void open() {
        System.out.println("Открыт документ: Письмо");
    }
}

class Invoice implements Document {
    @Override
    public void open() {
        System.out.println("Открыт документ: Счет (Invoice)");
    }
}

abstract class DocumentCreator {
    public abstract Document createDocument();
}

class ReportCreator extends DocumentCreator {
    @Override
    public Document createDocument() {
        return new Report();
    }
}

class ResumeCreator extends DocumentCreator {
    @Override
    public Document createDocument() {
        return new Resume();
    }
}

class LetterCreator extends DocumentCreator {
    @Override
    public Document createDocument() {
        return new Letter();
    }
}

class InvoiceCreator extends DocumentCreator {
    @Override
    public Document createDocument() {
        return new Invoice();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите тип документа:");
        System.out.println("1 - Отчет");
        System.out.println("2 - Резюме");
        System.out.println("3 - Письмо");
        System.out.println("4 - Счет (Invoice)");

        int choice = scanner.nextInt();

        DocumentCreator creator = null;

        switch (choice) {
            case 1:
                creator = new ReportCreator();
                break;
            case 2:
                creator = new ResumeCreator();
                break;
            case 3:
                creator = new LetterCreator();
                break;
            case 4:
                creator = new InvoiceCreator();
                break;
            default:
                System.out.println("Неверный выбор документа.");
                System.exit(0);
        }

        Document document = creator.createDocument();
        document.open();

        scanner.close();
    }
}
