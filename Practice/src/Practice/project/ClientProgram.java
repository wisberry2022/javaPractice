package Practice.project;

import java.awt.*;
import java.awt.event.*;
import java.util.*;


class MenuSet implements Comparable<Object> {
    private int idx;
    private String mainMenu;
    private ArrayList<String> subSet = new ArrayList<>();

    MenuSet(int idx, String name) {
        this.idx = idx;
        mainMenu = name;
    }

    String getMainMenu() {
        return this.mainMenu;
    }

    ArrayList<String> getSubMenu() {
        return this.subSet;
    }

    void addMenu(String menuName) {
        this.subSet.add(menuName);
    }

    @Override
    public int compareTo(Object o) {
        return this.idx - ((MenuSet)(o)).idx;
    }
}

class TopMenu extends Frame implements frameSet<MenuBar>{
    MenuBar mb = new MenuBar();

    public TopMenu() {
        String[][] items = {{"File","log export", "log import"},{"Info", "WSC help"}};

        Set<MenuSet> menuList = new TreeSet<>();

        for(int i = 0; i<items.length; i++) {
            String[] meta = items[i];
            MenuSet menu = new MenuSet(i, meta[0]);
            for(int j = 1; j<meta.length; j++) {
                menu.addMenu(meta[j]);
            }
            menuList.add(menu);
        }

        Iterator<MenuSet> ite = menuList.iterator();
        while(ite.hasNext()) {
            MenuSet menu = ite.next();
            Menu item = new Menu(menu.getMainMenu());
            ArrayList<String> subs = menu.getSubMenu();
            for(int i = 0; i<subs.size(); i++) {
                MenuItem mi = new MenuItem(subs.get(i));
                item.add(mi);
            }
            mb.add(item);
        }
    }

    public MenuBar getFrame() {
        return mb;
    }
}

class Monitor extends Frame {
    static Toolkit tk = Toolkit.getDefaultToolkit();
    static Dimension sizeManager = new Dimension(500, 800);
    static final int SCREEN_WIDTH = tk.getScreenSize().width;
    static final int SCREEN_HEIGHT = tk.getScreenSize().height;
    static final int PROGRAM_WIDTH = sizeManager.width;
    static final int PROGRAM_HEIGHT = sizeManager.height;
    static final PanelManager PM = new PanelManager();

    public Monitor() {
//        LayoutManager lm = new GridLayout(9,1);
        LayoutManager lm = new BorderLayout();

        setLayout(lm);
        int widPos = (int)(SCREEN_WIDTH/2) - (int)(PROGRAM_WIDTH/2);
        int hgtPos = (int)(SCREEN_HEIGHT/2) - (int)(PROGRAM_HEIGHT/2);
        setBounds(widPos, hgtPos, PROGRAM_WIDTH, PROGRAM_HEIGHT);
        setTitle("WSC");

        setMenuBar(new TopMenu().getFrame());

        Panel titlePanel = PM.getTitlePanel("WebCash Service Client");
        titlePanel.add(PM.getPadding(), BorderLayout.SOUTH);
        add(titlePanel, BorderLayout.NORTH);

        Panel CasePanel = PM.getCasePanel();
        CasePanel.setLayout(new BorderLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        Panel nameField = PM.getInputField();

        CasePanel.add(nameField, BorderLayout.NORTH);

        Panel selectBox = new Panel();
        selectBox.setLayout(new GridLayout(2,2, 5, 10));
        java.awt.List selection = PM.getSelectMenu();
        selectBox.add(selection);
        TextArea ta = new TextArea(10,10);
        selectBox.add(ta);
        CasePanel.add(selectBox);

        add(CasePanel, BorderLayout.CENTER);

        setVisible(true);

        // 닫기 event
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }
}


public class ClientProgram {

    public static void main(String[] args) {
        Monitor mn = new Monitor();

    }

}

