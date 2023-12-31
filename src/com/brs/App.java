package com.ydu;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class App {

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
    private JTextField reviewStartValue;
    private JComboBox reviewVotes;
    private JTextField reviewVotesValue;
    private JLabel from;
    private JLabel to;
    private JLabel star;
    private JLabel value6;
    private JPanel queryPanel;
    private JButton executeQueryButton;
    private JRadioButton businessRadioButton;
    private JRadioButton usersRadioButton;
    private JPanel reviewPanel1;
    private JDateChooser fromDatePicker;
    private JDateChooser toDatePicker;
    private JLabel votes;
    private JLabel value7;
    private JPanel reviewPanel2;
    private JPanel reviewPanel3;
    private JDateChooser memberSinceDatePicker;
    private JPanel queryShowPanel;


    public static void main(String[] args) {
        JFrame frame = new JFrame("Business Review System");
        frame.setContentPane(new App().AppUI);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        AppUI = new JPanel();
        AppUI.setLayout(new GridBagLayout());
        AppUI.setBackground(new Color(-1));
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
        businessPanel.setBorder(BorderFactory.createTitledBorder(null, "Business", TitledBorder.LEFT, TitledBorder.TOP, this.$$$getFont$$$(null, Font.BOLD, 16, businessPanel.getFont()), new Color(-1288153)));
        select1 = new JComboBox();
        select1.setBackground(new Color(-855310));
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("Select AND, OR between attributes");
        defaultComboBoxModel1.addElement("AND");
        defaultComboBoxModel1.addElement("OR");
        select1.setModel(defaultComboBoxModel1);
        businessPanel.add(select1, new GridConstraints(2, 0, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        searchFor1 = new JLabel();
        searchFor1.setForeground(new Color(-1288153));
        searchFor1.setText(" Search for");
        businessPanel.add(searchFor1, new GridConstraints(1, 0, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        categoryPanel = new JPanel();
        categoryPanel.setLayout(new GridLayoutManager(2, 1, new Insets(4, 0, 0, 0), -1, -1));
        categoryPanel.setBackground(new Color(-1288153));
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
        categoryItems.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        categoryItems.setBackground(new Color(-1));
        categoryList.setViewportView(categoryItems);
        attributePanel = new JPanel();
        attributePanel.setLayout(new GridLayoutManager(2, 1, new Insets(4, 0, 0, 0), -1, -1));
        attributePanel.setBackground(new Color(-1288153));
        businessPanel.add(attributePanel, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, 1, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(150, 200), null, 0, false));
        attributeLabel = new JLabel();
        attributeLabel.setForeground(new Color(-1));
        attributeLabel.setText("Attribute");
        attributePanel.add(attributeLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        attributeList = new JScrollPane();
        attributePanel.add(attributeList, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        attributeItems = new JPanel();
        attributeItems.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        attributeItems.setBackground(new Color(-1));
        attributeList.setViewportView(attributeItems);
        subCategoryPanel = new JPanel();
        subCategoryPanel.setLayout(new GridLayoutManager(2, 1, new Insets(4, 0, 0, 0), -1, -1));
        subCategoryPanel.setBackground(new Color(-1288153));
        businessPanel.add(subCategoryPanel, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, 1, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(150, 200), null, 0, false));
        subCategoryLabel = new JLabel();
        subCategoryLabel.setBackground(new Color(-1288153));
        subCategoryLabel.setForeground(new Color(-1));
        subCategoryLabel.setHorizontalAlignment(0);
        subCategoryLabel.setText("Sub-category");
        subCategoryPanel.add(subCategoryLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        subCategoryList = new JScrollPane();
        subCategoryList.setBackground(new Color(-1));
        subCategoryPanel.add(subCategoryList, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        subCategoryItems = new JPanel();
        subCategoryItems.setLayout(new GridBagLayout());
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
        ResultPanel.setBorder(BorderFactory.createTitledBorder(null, "Results", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, this.$$$getFont$$$(null, Font.BOLD, 16, ResultPanel.getFont()), new Color(-1288153)));
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
        reviewPanel.setBorder(BorderFactory.createTitledBorder(null, "Reviews", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, this.$$$getFont$$$(null, Font.BOLD, 16, reviewPanel.getFont()), new Color(-1288153)));
        reviewPanel1 = new JPanel();
        reviewPanel1.setLayout(new GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        reviewPanel1.setBackground(new Color(-1));
        reviewPanel.add(reviewPanel1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, 1, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(200, 57), null, 0, false));
        from = new JLabel();
        from.setText("From    ");
        reviewPanel1.add(from, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        to = new JLabel();
        to.setText("To      ");
        reviewPanel1.add(to, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        fromDatePicker = new JDateChooser();
        reviewPanel1.add( fromDatePicker, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        toDatePicker = new JDateChooser();
        reviewPanel1.add( toDatePicker, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        reviewPanel2 = new JPanel();
        reviewPanel2.setLayout(new GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        reviewPanel2.setBackground(new Color(-1));
        reviewPanel.add(reviewPanel2, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, 1, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(200, 57), null, 0, false));
        star = new JLabel();
        star.setText("Star     ");
        star.setVerifyInputWhenFocusTarget(true);
        reviewPanel2.add(star, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        value6 = new JLabel();
        value6.setText("Value   ");
        reviewPanel2.add(value6, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        reviewStar = new JComboBox();
        reviewStar.setBackground(new Color(-855310));
        final DefaultComboBoxModel defaultComboBoxModel2 = new DefaultComboBoxModel();
        defaultComboBoxModel2.addElement("Select a sign");
        defaultComboBoxModel2.addElement("=");
        defaultComboBoxModel2.addElement(">");
        defaultComboBoxModel2.addElement("<");
        defaultComboBoxModel2.addElement(">=");
        defaultComboBoxModel2.addElement("<=");
        reviewStar.setModel(defaultComboBoxModel2);
        reviewPanel2.add(reviewStar, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        reviewStartValue = new JTextField();
        reviewPanel2.add(reviewStartValue, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        reviewPanel3 = new JPanel();
        reviewPanel3.setLayout(new GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        reviewPanel3.setBackground(new Color(-1));
        reviewPanel.add(reviewPanel3, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, 1, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(200, 57), null, 0, false));
        votes = new JLabel();
        votes.setText("Votes");
        reviewPanel3.add(votes, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        value7 = new JLabel();
        value7.setText("Value   ");
        reviewPanel3.add(value7, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        reviewVotes = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel3 = new DefaultComboBoxModel();
        defaultComboBoxModel3.addElement("Select a sign");
        defaultComboBoxModel3.addElement("=");
        defaultComboBoxModel3.addElement(">");
        defaultComboBoxModel3.addElement("<");
        defaultComboBoxModel3.addElement(">=");
        defaultComboBoxModel3.addElement("<=");
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
        userPanel.setBorder(BorderFactory.createTitledBorder(null, "Users", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, this.$$$getFont$$$(null, Font.BOLD, 16, userPanel.getFont()), new Color(-1288153)));
        select2 = new JComboBox();
        select2.setEnabled(true);
        final DefaultComboBoxModel defaultComboBoxModel4 = new DefaultComboBoxModel();
        defaultComboBoxModel4.addElement("Select AND, OR between attributes");
        defaultComboBoxModel4.addElement("AND");
        defaultComboBoxModel4.addElement("OR");
        select2.setModel(defaultComboBoxModel4);
        userPanel.add(select2, new GridConstraints(2, 0, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        searchFor2 = new JLabel();
        searchFor2.setBackground(new Color(-1));
        searchFor2.setForeground(new Color(-1288153));
        searchFor2.setText(" Search for");
        userPanel.add(searchFor2, new GridConstraints(1, 0, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        items = new JPanel();
        items.setLayout(new GridLayoutManager(5, 1, new Insets(0, 0, 0, 0), -1, -1));
        items.setBackground(new Color(-1));
        userPanel.add(items, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, 1, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        memberSince = new JLabel();
        memberSince.setText("Member Since");
        items.add(memberSince, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, 1, null, null, null, 0, false));
        reviewCount = new JLabel();
        reviewCount.setText("Review Count");
        items.add(reviewCount, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        numberOfFriends = new JLabel();
        numberOfFriends.setText("Number of Friends");
        items.add(numberOfFriends, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        numberOfVotes = new JLabel();
        numberOfVotes.setText("Number of Votes");
        items.add(numberOfVotes, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        averageStars = new JLabel();
        averageStars.setText("Average Stars");
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
        value2 = new JLabel();
        value2.setText("Value");
        values.add(value2, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textField5 = new JTextField();
        values.add(textField5, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, 1, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        value4 = new JLabel();
        value4.setText("Value");
        values.add(value4, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textField4 = new JTextField();
        values.add(textField4, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
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
        conditions.add( memberSinceDatePicker, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
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
        queryPanel.setBorder(BorderFactory.createTitledBorder(null, "Query", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, this.$$$getFont$$$(null, Font.BOLD, 16, queryPanel.getFont()), new Color(-1288153)));
        executeQueryButton = new JButton();
        executeQueryButton.setBackground(new Color(-1288153));
        executeQueryButton.setForeground(new Color(-1));
        executeQueryButton.setText("Execute Query");
        queryPanel.add(executeQueryButton, new GridConstraints(2, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        queryShowPanel = new JPanel();
        queryShowPanel.setLayout(new GridBagLayout());
        queryShowPanel.setBackground(new Color(-1));
        queryShowPanel.setForeground(new Color(-855310));
        queryPanel.add(queryShowPanel, new GridConstraints(0, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(300, -1), null, 0, false));
        businessRadioButton = new JRadioButton();
        businessRadioButton.setBackground(new Color(-1));
        businessRadioButton.setForeground(new Color(-16777216));
        businessRadioButton.setText("Business");
        queryPanel.add(businessRadioButton, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        usersRadioButton = new JRadioButton();
        usersRadioButton.setBackground(new Color(-1));
        usersRadioButton.setText("User");
        queryPanel.add(usersRadioButton, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }
    
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
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
    
    public JComponent $$$getRootComponent$$$() {
        return AppUI;
    }
}
