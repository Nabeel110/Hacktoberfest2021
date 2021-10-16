/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import assignment.Buyer;
import assignment.Item;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import javax.swing.JFrame;

/**
 *
 * @author xxhackerxx
 */
public class BuyerViewItemOnSale extends javax.swing.JFrame {

    private Buyer buyer;

   
    public BuyerViewItemOnSale(Buyer buyer) {
        this.buyer = buyer;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ItemsOnSale = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ItemsCategory = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Trading System");
        setLocation(new java.awt.Point(380, 180));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(ItemsOnSale);

        jLabel2.setText("Please choose the cateogry you would like to show");

        ItemsCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Categories" }));
        ItemsCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemsCategoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(254, 254, 254)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(217, 217, 217)
                                .addComponent(ItemsCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jLabel2)
                .addContainerGap(156, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ItemsCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(9, 9, 9))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        ShowItems();
        // splitting the returned string which is categories
        String[] parts = String.valueOf(checkCategory()).split("-");
        for (int i = 0; i < parts.length; i++) {
            // adding avaliable categories to the JcomboBox
            ItemsCategory.addItem(parts[i]);
        }

    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        BuyerFrame b = new BuyerFrame(buyer);
        this.setVisible(false);
        b.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ItemsCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemsCategoryActionPerformed
       ShowItems();
    }//GEN-LAST:event_ItemsCategoryActionPerformed
    
    
    public void ShowItems(){
    ArrayList<Item> items = buyer.viewItemsByCategory(ItemsCategory.getSelectedItem().toString());
        ItemsOnSale.setText("<html>");
        for (Item item : items) {

            ItemsOnSale.setText(ItemsOnSale.getText() + "Item title: " + item.getItemTitle() + "<br>" + " Item Describtion: " + item.getItemDescribtion() + "<br>" + " Item Price: PKR" + item.getItemPrice() + "<br>" + " Item Category: " + item.getItemCategory() + "<br>" + " Method of delivery: " + item.getMethodOfDelivery() + "<br>" + " =================================================" + "<br>");

        }
        ItemsOnSale.setText(ItemsOnSale.getText() + "</html>");
    }
    
    
    public String checkCategory() {
        ArrayList<Item> items = buyer.viewItemsOnSale();
        ArrayList<String> categories = new ArrayList<String>();
        for (Item item : items) {
            String[] parts = item.toString().split("-");
            categories.add(parts[4]);
        }
        // Creating LinkedHashSet that allow you to remove the duplicated elements
        LinkedHashSet<String> Finalcategories = new LinkedHashSet<>();

        // Adding ArrayList elements to the LinkedHashSet to check the duplicated one and remove
        Finalcategories.addAll(categories);

        // Removing all the elments in the ArrayList
        categories.clear();

        // Adding the updated categories from the linked hash to the orginal ArrayList
        categories.addAll(Finalcategories);

        // building my own string format to return it insted of returning arrayList
        StringBuilder builder = new StringBuilder();
        for (String value : categories) {
            builder.append(value + "-");
        }
        String text = builder.toString();
        return text;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ItemsCategory;
    private javax.swing.JLabel ItemsOnSale;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
