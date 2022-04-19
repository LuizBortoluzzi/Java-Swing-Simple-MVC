package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllers.ProductController;

public class RegisterProductsView extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel background;
	private JPanel fields;
	private JPanel buttons;

	private JButton clearButton;
	private JButton searchButton;
	private JButton insertButton;
	private JButton updateButton;
	private JButton deleteButton;

	private JLabel codeLabel;
	private JLabel nameLabel;
	private JLabel descriptionLabel;

	private JTextField codeTextfield;
	private JTextField nameTextfield;
	private JTextField descriptionTextfield;

	private ProductController controller;

	private Map<String, String> inputValues = new HashMap<String, String>();

	public RegisterProductsView(ProductController controller) {

		super("Register Products");

		this.controller = controller;

		this.background = new JPanel(new BorderLayout());
		this.fields = new JPanel(new GridLayout(3, 2));
		this.buttons = new JPanel(new FlowLayout());

		this.codeLabel = new JLabel("Code:");
		this.nameLabel = new JLabel("Name:");
		this.descriptionLabel = new JLabel("Description:");

		this.codeTextfield = new JTextField(10);
		this.nameTextfield = new JTextField(30);
		this.descriptionTextfield = new JTextField(60);

		this.fields.add(codeLabel);
		this.fields.add(codeTextfield);
		this.fields.add(nameLabel);
		this.fields.add(nameTextfield);
		this.fields.add(descriptionLabel);
		this.fields.add(descriptionTextfield);

		this.background.add(this.fields, BorderLayout.CENTER);

		this.searchButton = new JButton("Search");
		this.searchButton.addActionListener(this);
		this.clearButton = new JButton("Clear");
		this.clearButton.addActionListener(this);
		this.insertButton = new JButton("Insert");
		this.insertButton.addActionListener(this);
		this.updateButton = new JButton("Update");
		this.updateButton.addActionListener(this);
		this.deleteButton = new JButton("Delete");
		this.deleteButton.addActionListener(this);

		this.buttons.add(searchButton);
		this.buttons.add(clearButton);
		this.buttons.add(insertButton);
		this.buttons.add(updateButton);
		this.buttons.add(deleteButton);

		this.background.add(this.buttons, BorderLayout.SOUTH);

		this.getContentPane().add(this.background);

		this.setSize(500, 150);
		this.setVisible(true);

		this.inputValues.put("code", this.codeTextfield.getText());
		this.inputValues.put("name", this.nameTextfield.getText());
		this.inputValues.put("description", this.descriptionTextfield.getText());
	}

	private void clear() {
		this.codeTextfield.setText("");
		this.nameTextfield.setText("");
		this.descriptionTextfield.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == clearButton) {

			this.clear();

		} else if (e.getSource() == searchButton) {

			this.inputValues.put("code", this.codeTextfield.getText());
			this.inputValues.put("name", this.nameTextfield.getText());
			this.inputValues.put("description", this.descriptionTextfield.getText());

			this.controller.setModelValues(this.inputValues);
			this.controller.search();

			this.inputValues = this.controller.getModelValues();

			this.codeTextfield.setText(this.inputValues.get("code"));
			this.nameTextfield.setText(this.inputValues.get("name"));
			this.descriptionTextfield.setText(this.inputValues.get("description"));

		} else if (e.getSource() == insertButton) {

			this.inputValues.put("code", this.codeTextfield.getText());
			this.inputValues.put("name", this.nameTextfield.getText());
			this.inputValues.put("description", this.descriptionTextfield.getText());

			this.controller.setModelValues(this.inputValues);
			this.controller.insert();

		} else if (e.getSource() == deleteButton) {

			int code = Integer.parseInt(this.codeTextfield.getText());
			this.controller.delete(code);

		} else if (e.getSource() == updateButton) {

			this.inputValues.put("code", this.codeTextfield.getText());
			this.inputValues.put("name", this.nameTextfield.getText());
			this.inputValues.put("description", this.descriptionTextfield.getText());

			this.controller.setModelValues(this.inputValues);
			this.controller.update();

		}
	}

}
