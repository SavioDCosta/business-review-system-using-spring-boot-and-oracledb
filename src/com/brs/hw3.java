package com.ydu;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.toedter.calendar.JDateChooser;

//import org.jdatepicker.JDatePicker;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class hw3 {
	
    private JPanel AppUI;
    private JPanel businessPanel;
    private JPanel categoryPanel;
    private JLabel categoryLabel;
    private JScrollPane categoryList;
    private JPanel subCategoryPanel;
    private JLabel subCategoryLabel;
    private JPanel categoryItems;
    private JScrollPane subCategoryList;
    private JPanel attributePanel;
    private JScrollPane attributeList;
    private JPanel subCategoryItems;
    private JPanel attributeItems;
    private JLabel attributeLabel;
    private JPanel reviewPanel;
    private JPanel ResultPanel;
    private JPanel userPanel;
    private JComboBox select1;
    private JLabel searchFor1;
    private JComboBox select2;
    private JLabel searchFor2;
    private JPanel items;
    private JPanel values;
    private JPanel conditions;
    private JComboBox condition1;
    private JComboBox condition2;
    private JComboBox condition3;
    private JComboBox condition4;
    private JLabel memberSince;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JLabel reviewCount;
    private JLabel numberOfFriends;
    private JLabel numberOfVotes;
    private JLabel averageStars;
    private JLabel value1;
    private JLabel value3;
    private JLabel value5;
    private JLabel value2;
    private JLabel value4;
    private JComboBox reviewStar;
    private JTextField reviewStarValue;
    private JComboBox reviewVotes;
    private JTextField reviewVotesValue;
    private JLabel from;
    private JLabel to;
    private JLabel star;
    private JLabel value6;
    private JPanel queryPanel;
    private JButton executeQueryButton;
    private JRadioButton businessRadioButton;
    private JRadioButton userRadioButton;
    private JPanel reviewPanel1;
    private JDateChooser fromDatePicker;
    private JDateChooser toDatePicker;
    private JLabel votes;
    private JLabel value7;
    private JPanel reviewPanel2;
    private JPanel reviewPanel3;
    private JDateChooser memberSinceDatePicker;
    private JPanel queryShowPanel;
    private JFrame GUI;

    private ArrayList<JCheckBox> mainCategories;
    private ArrayList<JCheckBox> subCategories;
    private ArrayList<JCheckBox> attributes;
    private Set<String> mainCategoriesSelected = new HashSet<>();
    private Set<String> subCategoriesSelected = new HashSet<>();
    private Set<String> attributesSelected = new HashSet<>();
    private String businessSearch;
    private String userSearch;

    private static final int FRAME_WIDTH = 1366;
    private static final int FRAME_HEIGHT = 768;
    private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String ORACLE_URL = "jdbc:oracle:thin:@10.0.0.227:1521:XE";
    private static final String USER_NAME = "SYSTEM";
    private static final String PASSWORD = "Stefan888";

    public hw3() throws ClassNotFoundException,SQLException{
        GUI = new JFrame();
        GUI.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GUI.setTitle("Business Review System");
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        int x = (screenWidth - FRAME_WIDTH) / 2;
        int y = (screenHeight - FRAME_HEIGHT) / 2;
        GUI.setLocation(x, y);
        AppUI = new JPanel();
        AppUI.setLayout(new GridBagLayout());
        AppUI.setBackground(new Color(255,255,255));
        businessPanel = new JPanel();
        businessPanel.setLayout(new GridLayoutManager(3, 3, new Insets(2, 2, 2, 2), -1, -1, true, false));
        businessPanel.setBackground(new Color(-1));
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 2.0;
        gbc.weighty = 2.0;
        gbc.fill = GridBagConstraints.BOTH;
        AppUI.add(businessPanel, gbc);
        businessPanel.setBorder(BorderFactory.createTitledBorder(null, "Business", TitledBorder.LEFT, TitledBorder.TOP, this.getFont(null, Font.BOLD, 16, businessPanel.getFont()), new Color(0x424CEC)));
        select1 = new JComboBox();
        select1.setBackground(new Color(-855310));
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("Select AND, OR between attributes");
        defaultComboBoxModel1.addElement("AND");
        defaultComboBoxModel1.addElement("OR");
        select1.setModel(defaultComboBoxModel1);
        select1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    updateSubCategories();
                    updateAttributes();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });
        businessPanel.add(select1, new GridConstraints(2, 0, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        searchFor1 = new JLabel();
        searchFor1.setForeground(new Color(0x424CEC));
        searchFor1.setText(" Search for");
        businessPanel.add(searchFor1, new GridConstraints(1, 0, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        categoryPanel = new JPanel();
        categoryPanel.setLayout(new GridLayoutManager(2, 1, new Insets(4, 0, 0, 0), -1, -1));
        categoryPanel.setBackground(new Color(0x424CEC));
        businessPanel.add(categoryPanel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, 1, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(150, 200), null, 0, false));
        categoryLabel = new JLabel();
        categoryLabel.setEnabled(true);
        categoryLabel.setForeground(new Color(-1));
        categoryLabel.setText("Category");
        categoryPanel.add(categoryLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        categoryList = new JScrollPane();
        categoryList.setBackground(new Color(-1));
        categoryList.setHorizontalScrollBarPolicy(31);
        categoryPanel.add(categoryList, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        categoryItems = new JPanel();
        //categoryItems.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        categoryItems.setLayout(new BoxLayout(categoryItems,BoxLayout.Y_AXIS));
        categoryItems.setBackground(new Color(-1));

        //initialize main category
        initMainCategory();

        /*
        for(int i = 0; i < main_category_pool.size(); i++){
            categoryItems.add(main_category_pool.get(i));
        }
        */

        categoryList.setViewportView(categoryItems);
        attributePanel = new JPanel();
        attributePanel.setLayout(new GridLayoutManager(2, 1, new Insets(4, 0, 0, 0), -1, -1));
        attributePanel.setBackground(new Color(0x424CEC));
        businessPanel.add(attributePanel, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, 1, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(150, 200), null, 0, false));
        attributeLabel = new JLabel();
        attributeLabel.setForeground(new Color(-1));
        attributeLabel.setText("Attribute");
        attributePanel.add(attributeLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        attributeList = new JScrollPane();
        attributePanel.add(attributeList, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        attributeItems = new JPanel();
        attributeItems.setLayout(new BoxLayout(attributeItems, BoxLayout.Y_AXIS));
        attributeItems.setBackground(new Color(-1));
        attributeList.setViewportView(attributeItems);
        subCategoryPanel = new JPanel();
        subCategoryPanel.setLayout(new GridLayoutManager(2, 1, new Insets(4, 0, 0, 0), -1, -1));
        subCategoryPanel.setBackground(new Color(0x424CEC));
        businessPanel.add(subCategoryPanel, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, 1, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(150, 200), null, 0, false));
        subCategoryLabel = new JLabel();
        subCategoryLabel.setBackground(new Color(0x424CEC));
        subCategoryLabel.setForeground(new Color(-1));
        subCategoryLabel.setHorizontalAlignment(0);
        subCategoryLabel.setText("Sub-category");
        subCategoryPanel.add(subCategoryLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        subCategoryList = new JScrollPane();
        subCategoryList.setBackground(new Color(-1));
        subCategoryPanel.add(subCategoryList, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        subCategoryItems = new JPanel();
        subCategoryItems.setLayout(new BoxLayout(subCategoryItems, BoxLayout.Y_AXIS));
        subCategoryItems.setBackground(new Color(-1));
        subCategoryList.setViewportView(subCategoryItems);
        ResultPanel = new JPanel();
        ResultPanel.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        ResultPanel.setBackground(new Color(-1));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 3.0;
        gbc.weighty = 2.0;
        gbc.fill = GridBagConstraints.BOTH;
        AppUI.add(ResultPanel, gbc);
        ResultPanel.setBorder(BorderFactory.createTitledBorder(null, "Results", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, this.getFont(null, Font.BOLD, 16, ResultPanel.getFont()), new Color(0x424CEC)));
        reviewPanel = new JPanel();
        reviewPanel.setLayout(new GridLayoutManager(3, 1, new Insets(10, 2, 10, 2), -1, -1));
        reviewPanel.setBackground(new Color(-1));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 2.0;
        gbc.fill = GridBagConstraints.BOTH;
        AppUI.add(reviewPanel, gbc);
        reviewPanel.setBorder(BorderFactory.createTitledBorder(null, "Reviews", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, this.getFont(null, Font.BOLD, 16, reviewPanel.getFont()), new Color(0x424CEC)));
        reviewPanel1 = new JPanel();
        reviewPanel1.setLayout(new GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        reviewPanel1.setBackground(new Color(-1));
        reviewPanel.add(reviewPanel1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, 1, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(200, 57), null, 0, false));
        from = new JLabel();
        from.setText("From: ");
        reviewPanel1.add(from, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        to = new JLabel();
        to.setText("To: ");
        reviewPanel1.add(to, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        fromDatePicker = new JDateChooser();
        reviewPanel1.add(fromDatePicker, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        toDatePicker = new JDateChooser();
        reviewPanel1.add(toDatePicker, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        reviewPanel2 = new JPanel();
        reviewPanel2.setLayout(new GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        reviewPanel2.setBackground(new Color(-1));
        reviewPanel.add(reviewPanel2, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, 1, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(200, 57), null, 0, false));
        star = new JLabel();
        star.setText("Star: ");
        star.setVerifyInputWhenFocusTarget(true);
        reviewPanel2.add(star, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        value6 = new JLabel();
        value6.setText("Value: ");
        reviewPanel2.add(value6, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        reviewStar = new JComboBox();
        reviewStar.setBackground(new Color(-855310));
        final DefaultComboBoxModel defaultComboBoxModel2 = new DefaultComboBoxModel();
        defaultComboBoxModel2.addElement("Select a sign: ");
        defaultComboBoxModel2.addElement(" = ");
        defaultComboBoxModel2.addElement(" > ");
        defaultComboBoxModel2.addElement(" < ");
        defaultComboBoxModel2.addElement(" >= ");
        defaultComboBoxModel2.addElement(" <= ");
        reviewStar.setModel(defaultComboBoxModel2);
        reviewPanel2.add(reviewStar, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        reviewStarValue = new JTextField();
        reviewPanel2.add(reviewStarValue, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        reviewPanel3 = new JPanel();
        reviewPanel3.setLayout(new GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        reviewPanel3.setBackground(new Color(-1));
        reviewPanel.add(reviewPanel3, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, 1, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(200, 57), null, 0, false));
        votes = new JLabel();
        votes.setText("Votes: ");
        reviewPanel3.add(votes, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        value7 = new JLabel();
        value7.setText("Value: ");
        reviewPanel3.add(value7, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        reviewVotes = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel3 = new DefaultComboBoxModel();
        defaultComboBoxModel3.addElement("Select a sign: ");
        defaultComboBoxModel3.addElement(" = ");
        defaultComboBoxModel3.addElement(" > ");
        defaultComboBoxModel3.addElement(" < ");
        defaultComboBoxModel3.addElement(" >= ");
        defaultComboBoxModel3.addElement(" <= ");
        reviewVotes.setModel(defaultComboBoxModel3);
        reviewPanel3.add(reviewVotes, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        reviewVotesValue = new JTextField();
        reviewPanel3.add(reviewVotesValue, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        userPanel = new JPanel();
        userPanel.setLayout(new GridLayoutManager(3, 3, new Insets(2, 2, 2, 2), -1, -1));
        userPanel.setBackground(new Color(-1));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 2.0;
        gbc.weighty = 2.0;
        gbc.fill = GridBagConstraints.BOTH;
        AppUI.add(userPanel, gbc);
        userPanel.setBorder(BorderFactory.createTitledBorder(null, "Users", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, this.getFont(null, Font.BOLD, 16, userPanel.getFont()), new Color(0x424CEC)));
        select2 = new JComboBox();
        select2.setEnabled(true);
        final DefaultComboBoxModel defaultComboBoxModel4 = new DefaultComboBoxModel();
        defaultComboBoxModel4.addElement("Select AND, OR between attributes: ");
        defaultComboBoxModel4.addElement(" AND ");
        defaultComboBoxModel4.addElement(" OR ");
        select2.setModel(defaultComboBoxModel4);
        userPanel.add(select2, new GridConstraints(2, 0, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        searchFor2 = new JLabel();
        searchFor2.setBackground(new Color(-1));
        searchFor2.setForeground(new Color(0x424CEC));
        searchFor2.setText(" Search for");
        userPanel.add(searchFor2, new GridConstraints(1, 0, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        items = new JPanel();
        items.setLayout(new GridLayoutManager(5, 1, new Insets(0, 0, 0, 0), -1, -1));
        items.setBackground(new Color(-1));
        userPanel.add(items, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, 1, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        memberSince = new JLabel();
        memberSince.setText("Member Since: ");
        items.add(memberSince, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, 1, null, null, null, 0, false));
        reviewCount = new JLabel();
        reviewCount.setText("Review Count: ");
        items.add(reviewCount, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        numberOfFriends = new JLabel();
        numberOfFriends.setText("Number of Friends: ");
        items.add(numberOfFriends, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        numberOfVotes = new JLabel();
        numberOfVotes.setText("Number of Votes: ");
        items.add(numberOfVotes, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        averageStars = new JLabel();
        averageStars.setText("Average Stars: ");
        items.add(averageStars, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        values = new JPanel();
        values.setLayout(new GridLayoutManager(5, 2, new Insets(0, 0, 0, 0), -1, -1, false, true));
        values.setBackground(new Color(-1));
        userPanel.add(values, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        value1 = new JLabel();
        value1.setText("");
        values.add(value1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textField2 = new JTextField();
        values.add(textField2, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, 1, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        textField3 = new JTextField();
        values.add(textField3, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, 1, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        value3 = new JLabel();
        value3.setText("Value");
        values.add(value3, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        value5 = new JLabel();
        value5.setText("Value");
        values.add(value5, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textField4 = new JTextField();
        values.add(textField4, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        value2 = new JLabel();
        value2.setText("Value");
        values.add(value2, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textField5 = new JTextField();
        values.add(textField5, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, 1, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        value4 = new JLabel();
        value4.setText("Value");
        values.add(value4, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        conditions = new JPanel();
        conditions.setLayout(new GridLayoutManager(5, 1, new Insets(0, 0, 0, 0), -1, -1, false, true));
        conditions.setBackground(new Color(-1));
        userPanel.add(conditions, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        condition1 = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel5 = new DefaultComboBoxModel();
        defaultComboBoxModel5.addElement("Select a sign");
        defaultComboBoxModel5.addElement("=");
        defaultComboBoxModel5.addElement(">");
        defaultComboBoxModel5.addElement("<");
        defaultComboBoxModel5.addElement(">=");
        defaultComboBoxModel5.addElement("<=");
        condition1.setModel(defaultComboBoxModel5);
        conditions.add(condition1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        condition2 = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel6 = new DefaultComboBoxModel();
        defaultComboBoxModel6.addElement("Select a sign");
        defaultComboBoxModel6.addElement("=");
        defaultComboBoxModel6.addElement(">");
        defaultComboBoxModel6.addElement("<");
        defaultComboBoxModel6.addElement(">=");
        defaultComboBoxModel6.addElement("<=");
        condition2.setModel(defaultComboBoxModel6);
        conditions.add(condition2, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        condition3 = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel7 = new DefaultComboBoxModel();
        defaultComboBoxModel7.addElement("Select a sign");
        defaultComboBoxModel7.addElement("=");
        defaultComboBoxModel7.addElement(">");
        defaultComboBoxModel7.addElement("<");
        defaultComboBoxModel7.addElement(">=");
        defaultComboBoxModel7.addElement("<=");
        condition3.setModel(defaultComboBoxModel7);
        conditions.add(condition3, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        condition4 = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel8 = new DefaultComboBoxModel();
        defaultComboBoxModel8.addElement("Select a sign");
        defaultComboBoxModel8.addElement("=");
        defaultComboBoxModel8.addElement(">");
        defaultComboBoxModel8.addElement("<");
        defaultComboBoxModel8.addElement(">=");
        defaultComboBoxModel8.addElement("<=");
        condition4.setModel(defaultComboBoxModel8);
        conditions.add(condition4, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        memberSinceDatePicker = new JDateChooser();
        conditions.add(memberSinceDatePicker, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        queryPanel = new JPanel();
        queryPanel.setLayout(new GridLayoutManager(3, 2, new Insets(2, 2, 2, 2), -1, -1));
        queryPanel.setBackground(new Color(-1));
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 2.0;
        gbc.weighty = 2.0;
        gbc.fill = GridBagConstraints.BOTH;
        AppUI.add(queryPanel, gbc);
        queryPanel.setBorder(BorderFactory.createTitledBorder(null, "Query", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, this.getFont(null, Font.BOLD, 16, queryPanel.getFont()), new Color(0x424CEC)));
        executeQueryButton = new JButton();
        executeQueryButton.setBackground(new Color(0x424CEC));
        executeQueryButton.setForeground(new Color(-1));
        executeQueryButton.setText("Execute Query");
        executeQueryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(userRadioButton.isSelected()){
                    try {
                        getUserResults();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    } catch (ClassNotFoundException e1) {
                        e1.printStackTrace();
                    }
                }else{
                    try {
                        getBusinessResults();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    } catch (ClassNotFoundException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        queryPanel.add(executeQueryButton, new GridConstraints(2, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        queryShowPanel = new JPanel();
        queryShowPanel.setLayout(new GridBagLayout());
        queryShowPanel.setBackground(new Color(-1));
        queryShowPanel.setForeground(new Color(-855310));
        queryPanel.add(queryShowPanel, new GridConstraints(0, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(300, -1), null, 0, false));
        businessRadioButton = new JRadioButton();
        businessRadioButton.setBackground(new Color(-1));
        //businessRadioButton.setForeground(new Color(-16777216));
        businessRadioButton.setText("Business");
        userRadioButton = new JRadioButton();
        userRadioButton.setBackground(new Color(-1));
        userRadioButton.setText("User");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(businessRadioButton);
        buttonGroup.add(userRadioButton);
        queryPanel.add(businessRadioButton, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        queryPanel.add(userRadioButton, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        GUI.add(AppUI);
        GUI.setVisible(true);

    }

    private Font getFont(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    public static Connection connectDB() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(ORACLE_URL, USER_NAME, PASSWORD);
        return connection;
    }

    public void initMainCategory()throws ClassNotFoundException, SQLException {
        mainCategories = new ArrayList<>();
        Connection connection = connectDB();
        Statement statement = connection.createStatement();
        String query = "SELECT DISTINCT MAIN_CATEGORY FROM MAIN_CATEGORIES ORDER BY main_category";
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            JCheckBox category = new JCheckBox(resultSet.getString(1));
            category.setBackground(new Color(-1));
            category.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (category.isSelected()) {
                        mainCategoriesSelected.add(category.getText());
                    } else {
                        mainCategoriesSelected.remove(category.getText());
                    }
                    try{
                        updateSubCategories();
                        updateAttributes();
                    }catch (SQLException a){
                        System.out.println(a);
                    }catch (ClassNotFoundException b){
                        System.out.println(b);
                    }

                }
            });
            //main_category_pool.add(category);
            categoryItems.add(category);
        }
        connection.close();
    }

    public void updateSubCategories() throws SQLException, ClassNotFoundException {
        subCategories = new ArrayList<>();
        subCategoryItems.removeAll();
        if("AND".equals(select1.getSelectedItem().toString())){
            businessSearch = "INTERSECT";
        }else{
            businessSearch = "UNION";
        }
        if(!mainCategoriesSelected.isEmpty()){
            String query = "SELECT DISTINCT SC.sub_category FROM SUB_CATEGORIES SC WHERE SC.business_id IN(";
            String sub_query = getMainCategoryQuery();
            query = query + sub_query + ") ORDER BY SC.sub_category";
            System.out.println(query);
            Connection connection = connectDB();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            Set<String> update_checked_sub_categories = new HashSet<>();
            while (resultSet.next()) {
                JCheckBox sub_category = new JCheckBox(resultSet.getString(1));
                if(subCategoriesSelected.contains(resultSet.getString(1))){
                    sub_category.setSelected(true);
                    update_checked_sub_categories.add(sub_category.getText());}
                sub_category.setBackground(new Color(-1));
                sub_category.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        if (sub_category.isSelected()) {
                            subCategoriesSelected.add(sub_category.getText());
                        } else {
                            subCategoriesSelected.remove(sub_category.getText());
                        }
                        try{
                            updateAttributes();
                        }catch (SQLException a){
                            System.out.println(a);
                        }catch (ClassNotFoundException b){
                            System.out.println(b);
                        }
                    }
                });
                subCategoryItems.add(sub_category);
                subCategories.add(sub_category);
            }
            subCategoriesSelected = update_checked_sub_categories;
            subCategoryItems.updateUI();
            connection.close();
        }else{
            subCategoriesSelected.clear();
            attributesSelected.clear();
            attributeItems.removeAll();
            subCategoryItems.updateUI();
            attributeItems.updateUI();
        }
    }

    public void updateAttributes() throws SQLException, ClassNotFoundException{
        attributes = new ArrayList<>();
        attributeItems.removeAll();
        if (!subCategoriesSelected.isEmpty() && !mainCategoriesSelected.isEmpty()){
            String query = "SELECT DISTINCT BA.attribute_key, BA.attribute_value FROM BUSINESS_ATTRIBUTES BA WHERE BA.business_id IN (";
            String sub_query_sc = getSubCategoryQuery();
            String sub_query_mc = getMainCategoryQuery();
            String sub_query = "";
            if(!sub_query_mc.isEmpty() && !sub_query_sc.isEmpty()){
                sub_query = sub_query_mc + " INTERSECT " + sub_query_sc;
            }else if(!sub_query_mc.isEmpty()){
                sub_query = sub_query_mc;
            }else{
                sub_query = sub_query_sc;
            }
            query = query + sub_query + ")";
            query = query + " ORDER BY BA.attribute_key";
            System.out.println(query);
            Connection connection = connectDB();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            Set<String> update_checked_attributes = new HashSet<>();
            while(resultSet.next()){
                JCheckBox attribute;
                /*
                if("true".equals(resultSet.getString(2))){
                    attribute = new JCheckBox(resultSet.getString(1));
                }else if(!"false".equals(resultSet.getString(2))){
                    attribute = new JCheckBox(resultSet.getString(1) + " : " + resultSet.getString(2));
                }else{
                    continue;
                }
                */
                attribute = new JCheckBox(resultSet.getString(1) + " : " + resultSet.getString(2));
                if(attributesSelected.contains(attribute.getText())){
                    attribute.setSelected(true);
                    update_checked_attributes.add(attribute.getText());
                }
                attribute.setBackground(new Color(-1));
                attribute.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        if(attribute.isSelected()){
                            attributesSelected.add(attribute.getText());
                        }else{
                            attributesSelected.remove(attribute.getText());
                        }
                    }
                });
                attributeItems.add(attribute);
            }
            attributesSelected = update_checked_attributes;
            attributeItems.updateUI();
            connection.close();

        }else{
            attributesSelected.clear();
            attributeItems.updateUI();
        }

    }

    public void getUserResults() throws SQLException, ClassNotFoundException{
        String query = "SELECT U.name, U.created_date, U.average_stars, U.user_id FROM USERS U ";
        if((condition1.getSelectedIndex() > 0 && isNumber(textField4.getText()))||(condition2.getSelectedIndex() > 0 && isNumber(textField3.getText()))
                || (condition3.getSelectedIndex() > 0 && isNumber(textField5.getText()))|| (condition4.getSelectedIndex() > 0 && isNumber(textField2.getText()))
                || memberSinceDatePicker.getDate() != null){
            query = query + "WHERE ";
        }
        if(select2.getSelectedIndex() > 0){
            userSearch = select2.getSelectedItem().toString();
        }else{
            userSearch = "OR";
        }
        if(condition1.getSelectedIndex() > 0 && isNumber(textField4.getText())){
            query = query + "U.review_count " + condition1.getSelectedItem().toString() + " " + textField4.getText() + " " + userSearch + " ";
        }
        if(condition2.getSelectedIndex() > 0 && isNumber(textField3.getText())){
            query = query + "U.friend_count " + condition2.getSelectedItem().toString() + " " + textField3.getText() + " " + userSearch + " ";
        }
        if(condition3.getSelectedIndex() > 0 && isNumber(textField5.getText())){
            query = query + "U.average_stars " + condition3.getSelectedItem().toString() + " " + textField5.getText() + " " + userSearch + " ";
        }
        if(condition4.getSelectedIndex() > 0 && isNumber(textField2.getText())){
            query = query + "U.votes " + condition4.getSelectedItem().toString() + " " + textField2.getText() + " " + userSearch + " ";
        }
        if(memberSinceDatePicker.getDate() != null){
        	SimpleDateFormat memberSince = new SimpleDateFormat("MM-YYYY");
        	String memberSinceString = memberSince.format(memberSinceDatePicker.getDate());
            //int month = memberSinceDatePicker.getModel().getMonth()+1;
            //int year = memberSinceDatePicker.getModel().getYear();
            query = query + "U.created_date" + " >= " + "TO_DATE('" + memberSinceString + "','MM-YYYY') " + userSearch + " ";
        }
        query = query.substring(0, query.length()- userSearch.length()-2);
        JTextArea show_query = new JTextArea();
        show_query.setEditable(false);
        show_query.setLineWrap(true);
        show_query.setWrapStyleWord(true);
        show_query.setText(query);
        JScrollPane queryShowPane = new JScrollPane(show_query);
        queryShowPane.setPreferredSize(new Dimension(340, 180));
        queryShowPanel.removeAll();
        queryShowPanel.add(queryShowPane);
        queryShowPanel.updateUI();
        System.out.println(query);
        Connection connection = connectDB();
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery(query);
        String[] columnNames = {"Name", "Created Date", "Average Stars"};
        resultSet.last();
        String[][] results = new String[resultSet.getRow()][3];
        String[] user_ids = new String[resultSet.getRow()];
        resultSet.beforeFirst();
        int i = 0;
        while(resultSet.next()){
            results[i][0] = resultSet.getString(1);
            results[i][1] = resultSet.getDate(2).toString();
            results[i][2] = resultSet.getString(3);
            user_ids[i] = resultSet.getString(4);
            i++;
        }
        JTable showResults = new JTable(results, columnNames);
        showResults.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = showResults.getSelectedRow();
                String user_id = user_ids[row];
                try {
                    show_user_review(user_id);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });
        JScrollPane resultsPane = new JScrollPane(showResults);
        resultsPane.setPreferredSize(new Dimension(500, 200));
        //resultsPane.setSize(550, 200);
        ResultPanel.removeAll();
        ResultPanel.add(resultsPane, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, true));
        ResultPanel.updateUI();
    }

   

    public String getMainCategoryQuery(){
        String sub_query_mc = "";
        if("AND".equals(select1.getSelectedItem().toString())){
            businessSearch = "INTERSECT";
        }else{
            businessSearch = "UNION";
        }
        int i = 1;
        for(String s: mainCategoriesSelected){
            sub_query_mc = sub_query_mc + "(SELECT MC" + i + ".business_id FROM MAIN_CATEGORIES MC" + i + " WHERE MC" + i + ".main_category = '" + s + "') " + businessSearch + " ";
            i++;
        }
        if(sub_query_mc.length() > 0) sub_query_mc = sub_query_mc.substring(0, sub_query_mc.length()- businessSearch.length()-2);
        return sub_query_mc;
    }

    public String getSubCategoryQuery(){
        String sub_query_sc = "";
        int i = 1;
        if("AND".equals(select1.getSelectedItem().toString())){
            businessSearch = "INTERSECT";
        }else{
            businessSearch = "UNION";
        }
        for(String s: subCategoriesSelected){
            sub_query_sc = sub_query_sc + "(SELECT SC" + i + ".business_id FROM SUB_CATEGORIES SC" + i + " WHERE SC" + i + ".sub_category = '" + s + "') " + businessSearch + " ";
            i++;
        }
        if(sub_query_sc.length() > 0) sub_query_sc = sub_query_sc.substring(0, sub_query_sc.length()- businessSearch.length()-2);
        return sub_query_sc;
    }

    public String getAttributeQuery(){
        String sub_query_ba = "";
        if("AND".equals(select1.getSelectedItem().toString())){
            businessSearch = "INTERSECT";
        }else{
            businessSearch = "UNION";
        }
        int i = 1;
        for(String s: attributesSelected){
            String[] key_value = s.split(" : ");
            String key, value;
            /*
            if(key_value.length == 1){
                key = key_value[0];
                value = "true";
            }else{
                key = key_value[0];
                value = key_value[1];
            }
            */
            key = key_value[0];
            value = key_value[1];
            sub_query_ba = sub_query_ba + "(SELECT BA" + i + ".business_id FROM BUSINESS_ATTRIBUTES BA" + i + " WHERE BA" + i + ".attribute_key = '" + key + "' AND BA" + i + ".attribute_value = '" + value + "') " + businessSearch + " ";
            i++;
        }
        if(sub_query_ba.length() > 0) sub_query_ba = sub_query_ba.substring(0, sub_query_ba.length()- businessSearch.length()-2);
        return sub_query_ba;
    }

    public String getReviewQuery(){
        String sub_query = "";
        String sub_query_r = "SELECT R.business_id, AVG(stars) AS average_stars, COUNT(votes) AS total_votes FROM REVIEWS R ";
        if("AND".equals(select1.getSelectedItem().toString())){
            businessSearch = "AND";
        }else{
            businessSearch = "OR";
        }
        if(fromDatePicker.getDate() != null || toDatePicker.getDate() != null){
            sub_query_r = sub_query_r + "WHERE ";
            SimpleDateFormat fromDate = new SimpleDateFormat("MM-dd-YYYY");
            SimpleDateFormat toDate = new SimpleDateFormat("MM-dd-YYYY");
            String fromDateString = fromDate.format(fromDatePicker.getDate());
            String toDateString = toDate.format(toDatePicker.getDate());
//            int from_year = fromDatePicker.getDate().getYear();
//            int from_month = fromDatePicker.getDate().getMonth() + 1;
//            int from_day = fromDatePicker.getDate().getDay() + 7;
//            int to_year = toDatePicker.getDate().getYear();
//            int to_month = toDatePicker.getDate().getMonth() + 1;
//            int to_day = toDatePicker.getDate().getDay() + 7;
            if(fromDatePicker.getDate() != null && toDatePicker.getDate() != null){

                //sub_query_r = sub_query_r + "R.publish_date >= TO_DATE('" + from_month + "-" + from_day + "-" + from_year + "','MM-DD-YYYY') AND R.publish_date <= TO_DATE('" + to_month + "-" + to_day + "-" + to_year + "','MM-DD-YYYY') ";
            	sub_query_r = sub_query_r + "R.publish_date >= TO_DATE('" + fromDateString + "','MM-DD-YYYY') AND R.publish_date <= TO_DATE('" + toDateString + "','MM-DD-YYYY') ";
            }else if(fromDatePicker.getDate() != null){
                //sub_query_r = sub_query_r + "R.publish_date >= TO_DATE('" + from_month + "-" + from_day + "-" + from_year + "','MM-DD-YYYY') ";
            	sub_query_r = sub_query_r + "R.publish_date >= TO_DATE('" + fromDateString + "','MM-DD-YYYY') ";
            }else{
                //sub_query_r = sub_query_r + "R.publish_date <= TO_DATE('" + to_month + "-" + to_day + "-" + to_year + "','MM-DD-YYYY') ";
            	sub_query_r = sub_query_r + "R.publish_date <= TO_DATE('" + toDateString + "','MM-DD-YYYY') ";
            }
        }
        sub_query_r = sub_query_r + "GROUP BY R.business_id";
        sub_query = "SELECT R1.business_id FROM (" + sub_query_r + ") R1 ";
        if((reviewStar.getSelectedIndex() > 0 && isNumber(reviewStarValue.getText())) || (reviewVotes.getSelectedIndex() > 0 && isNumber(reviewVotesValue.getText()))){
            sub_query = sub_query + "WHERE ";
            if((reviewStar.getSelectedIndex() > 0 && isNumber(reviewStarValue.getText())) && (reviewVotes.getSelectedIndex() > 0 && isNumber(reviewVotesValue.getText()))){
                sub_query = sub_query + "R1.average_stars " + reviewStar.getSelectedItem().toString() + " " + reviewStarValue.getText() + " " + businessSearch +" R1.total_votes " + reviewVotes.getSelectedItem().toString() + " " + reviewVotesValue.getText();
            }else if((reviewStar.getSelectedIndex() > 0 && isNumber(reviewStarValue.getText()))){
                sub_query = sub_query + "R1.average_stars " + reviewStar.getSelectedItem().toString() + " " + reviewStarValue.getText();
            }else{
                sub_query = sub_query + "R1.average_stars " + reviewStar.getSelectedItem().toString() + " " + reviewStarValue.getText();
            }
        }

        return sub_query;
    }



    public void getBusinessResults() throws SQLException, ClassNotFoundException{
        String query = "SELECT B.business_name, B.city, B.state, B.stars, B.business_id FROM BUSINESS B WHERE B.business_id IN(";
        String sub_query_mc = getMainCategoryQuery();
        String sub_query_sc = getSubCategoryQuery();
        String sub_query_ba = getAttributeQuery();
        String sub_query_r = getReviewQuery();
        //query = query + sub_query_mc + INTERSECT + sub_query_sc + INTERSECT + sub_query_ba + INTERSECT + subquery_r;
        ArrayList<String> sub_queries = new ArrayList<>();
        if(!sub_query_mc.isEmpty()) sub_queries.add(sub_query_mc);
        if(!sub_query_sc.isEmpty()) sub_queries.add(sub_query_sc);
        if(!sub_query_ba.isEmpty()) sub_queries.add(sub_query_ba);
        if((fromDatePicker.getDate() != null && toDatePicker.getDate() != null)
                || (reviewStar.getSelectedIndex() > 0 && isNumber(reviewStarValue.getText()))
                || (reviewVotes.getSelectedIndex() > 0 && isNumber(reviewVotesValue.getText())))
            sub_queries.add(sub_query_r);
        String sub_query = "";
        for(String s: sub_queries){
            sub_query = sub_query + "(" + s + ")" + " INTERSECT ";
        }
        sub_query = sub_query.substring(0, sub_query.length() - 11);
        query = query + sub_query + ")";
        System.out.println(query);
        JTextArea show_query = new JTextArea();
        show_query.setEditable(false);
        show_query.setLineWrap(true);
        show_query.setWrapStyleWord(true);
        show_query.setText(query);
        JScrollPane queryShowPane = new JScrollPane(show_query);
        queryShowPane.setPreferredSize(new Dimension(340, 180));
        queryShowPanel.removeAll();
        queryShowPanel.add(queryShowPane);
        queryShowPanel.updateUI();
        Connection connection = connectDB();
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        System.out.println("result returns!");
        ResultSet resultSet = statement.executeQuery(query);
        String[] columnNames = {"Business Name", "City", "State", "Stars"};
        resultSet.last();
        String[][] results = new String[resultSet.getRow()][4];
        String[] business_ids = new String[resultSet.getRow()];
        resultSet.beforeFirst();
        int i = 0;
        while(resultSet.next()){
            results[i][0] = resultSet.getString(1);
            results[i][1] = resultSet.getString(2);
            results[i][2] = resultSet.getString(3);
            results[i][3] = resultSet.getString(4);
            business_ids[i] = resultSet.getString(5);
            i++;
        }
        JTable showResults = new JTable(results, columnNames);
        showResults.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = showResults.getSelectedRow();
                String business_id = business_ids[row];
                try {
                    show_business_review(business_id);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });
        JScrollPane resultsPane = new JScrollPane(showResults);
        resultsPane.setPreferredSize(new Dimension(500, 200));
        //resultsPane.setSize(550, 200);
        ResultPanel.removeAll();
        ResultPanel.add(resultsPane, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, true));
        ResultPanel.updateUI();
        connection.close();
    }

    public void show_user_review(String user_id) throws SQLException, ClassNotFoundException{
        String query = "SELECT review_id, name FROM REVIEWS, USERS WHERE author = '" + user_id + "' AND author = user_id";
        Connection connection = connectDB();
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery(query);
        String[] columnNames = {"Review_id", "User_name"};
        resultSet.last();
        String[][] results = new String[resultSet.getRow()][2];
        resultSet.beforeFirst();
        int i = 0;
        while(resultSet.next()){
            results[i][0] = resultSet.getString(1);
            results[i][1] = resultSet.getString(2);
            i++;
        }
        JFrame pop_up = new JFrame();
        pop_up.setSize(400, 300);
        pop_up.setTitle("Reviews");
        pop_up.setBackground(new Color(-1));
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        int x = (screenWidth - 400) / 2;
        int y = (screenHeight - 300) / 2;
        pop_up.setLocation(x, y);
        JPanel pop_up_panel = new JPanel();
        pop_up_panel.setLayout(new BorderLayout());
        pop_up_panel.setBackground(new Color(-1));;

        JTable showResults = new JTable(results, columnNames);
        showResults.setBackground(new Color(-1));
        JScrollPane resultsPane = new JScrollPane(showResults);
        resultsPane.setPreferredSize(new Dimension(400, 300));
        resultsPane.setBackground(new Color(-1));
        /*
        JButton confirm = new JButton("return");
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pop_up.setVisible(false);
            }
        });
        */
        pop_up_panel.add(resultsPane, BorderLayout.CENTER);
        //pop_up_panel.add(confirm, BorderLayout.SOUTH);
        pop_up.add(pop_up_panel);
        pop_up.setVisible(true);
    }

    public void show_business_review(String business_id) throws SQLException, ClassNotFoundException{
        String query = "SELECT review_id, name FROM REVIEWS, USERS WHERE business_id = '" + business_id + "' AND author = user_id";
        Connection connection = connectDB();
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery(query);
        String[] columnNames = {"Review_id", "User_name"};
        resultSet.last();
        String[][] results = new String[resultSet.getRow()][2];
        resultSet.beforeFirst();
        int i = 0;
        while(resultSet.next()){
            results[i][0] = resultSet.getString(1);
            results[i][1] = resultSet.getString(2);
            i++;
        }
        JFrame pop_up = new JFrame();
        pop_up.setSize(400, 300);
        pop_up.setTitle("Reviews");
        pop_up.setBackground(new Color(-1));
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        int x = (screenWidth - 400) / 2;
        int y = (screenHeight - 300) / 2;
        pop_up.setLocation(x, y);
        JPanel pop_up_panel = new JPanel();
        pop_up_panel.setLayout(new BorderLayout());
        pop_up_panel.setBackground(new Color(-1));;

        JTable showResults = new JTable(results, columnNames);
        showResults.setBackground(new Color(-1));
        JScrollPane resultsPane = new JScrollPane(showResults);
        resultsPane.setPreferredSize(new Dimension(400, 300));
        resultsPane.setBackground(new Color(-1));
        /*
        JButton confirm = new JButton("return");
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pop_up.setVisible(false);
            }
        });
        */
        pop_up_panel.add(resultsPane, BorderLayout.CENTER);
        //pop_up_panel.add(confirm, BorderLayout.SOUTH);
        pop_up.add(pop_up_panel);
        pop_up.setVisible(true);
    }

    public static boolean isNumber(String strNum) {
        boolean ret = true;
        try {

            Double.parseDouble(strNum);

        }catch (NumberFormatException e) {
            ret = false;
        }
        return ret;
    }

    public static void main(String[] args) {
        try{
            hw3 test_ui = new hw3();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
