import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JMenuBar;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

/*
 * UIManagement Class
 * Last Updated: 2024-11-04
 * Purpose: To house and handle all UI elements for the City of Windsor Open Catalogue
 * Notes: To see any changes for the catalog, you must call updateCatalog(). Login Functionality Added
 * 		  TODO: Dataset Functionality
 * */
public class UIManagement extends JFrame {

	private JPanel contentPane;
	private JTextField txtKeyword;
	
	private String[] resourceList = {".txt"};
	private List<String> filterList = new ArrayList<>();
	
	private static int dataBaseSize = 0;
	private List<CatalogEntry> catalogEntries = new ArrayList<>();
	
	//Store the displays for quick future use
	JMenuBar menuBar;
	JPanel mainDashboard;
	
	//Login Method Variables
    private static final long serialVersionUID = 1L;
    private JTextField usernameField;
    private JTextField emailField;
    private JPasswordField passwordField;

	
	/**
	 * UIManagement Method
	 * Last Updated: 2024-11-04
	 * Purpose: Creates the basic frame that will store all elements
	 */
	public UIManagement() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 845, 664);
		menuBar = createMenuBar();
		mainDashboard = createMainDashboard();
		setContentPane(mainDashboard);
	}
	
	public void updateDataBaseSize(int num) {
		dataBaseSize = num;
	}
	
	public void updateCatalog() {
		getContentPane().remove(mainDashboard);
		mainDashboard = createMainDashboard();
	    setContentPane(mainDashboard);
	    
	    revalidate();
	    repaint();
	}
	
	
	public void addToCatalog(CatalogEntry newEntry) {
		dataBaseSize ++;
		catalogEntries.add(newEntry);
	}
	
	public void clearCatalog() {
		dataBaseSize = 0;
		catalogEntries.clear();
	}
	
	/*
	 * createMenuBar Method
	 * Last Updated: 2024-11-04
	 * Purpose: Creates the top menu bar that may be required for global access
	 * */
	private JMenuBar createMenuBar() {
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setMargin(new Insets(100, 0, 100, 0));
		menuBar_1.setForeground(new Color(48, 44, 44));
		menuBar_1.setBorderPainted(false);
		menuBar_1.setBackground(new Color(48, 44, 44));
		getComponentOrientation();
		menuBar_1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		setJMenuBar(menuBar_1);
		
		JButton btnNewButton_1 = new JButton("RSS");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(48, 44, 44));
		btnNewButton_1.setBorderPainted(false);
		menuBar_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Accessibility");
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(48, 44, 44));
		btnNewButton_2.setBorderPainted(false);
		menuBar_1.add(btnNewButton_2);
		
		JButton loginButton = new JButton("LOGIN/SIGN-UP");
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			    setContentPane(Login());
			    
			    revalidate();
			    repaint();
			}
		});
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		loginButton.setForeground(new Color(255, 255, 255));
		loginButton.setBackground(new Color(128, 128, 128));
		menuBar_1.add(loginButton);
		
		
		
		
		return menuBar_1;
	}
	
	/*
	 * createMainDashboard Method
	 * Last Updated: 2024-11-04
	 * Purpose: Creates the main dash board that is visible to all users and houses the main open
	 * 			catalog elements along with filter features.
	 * */
	private JPanel createMainDashboard() {

		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(Color.white);
		contentPane.add(scrollPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(new Dimension(1000, 2000));
		scrollPane.setViewportView(layeredPane);
		
		JLabel lbCatalog1 = new JLabel("City of Windsor Open Data Catalog");
		lbCatalog1.setBounds(10, 10, 233, 20);
		layeredPane.add(lbCatalog1);
		lbCatalog1.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		
		JLabel lbCatalog2 = new JLabel("Open Data Catalog");
		lbCatalog2.setBounds(67, 27, 233, 42);
		layeredPane.add(lbCatalog2);
		lbCatalog2.setFont(new Font("Yu Gothic UI", Font.BOLD, 24));
		
		JTextArea txtCatalog1 = new JTextArea();
		txtCatalog1.setBounds(67, 68, 660, 64);
		layeredPane.add(txtCatalog1);
		txtCatalog1.setEditable(false);
		txtCatalog1.setWrapStyleWord(true);
		txtCatalog1.setFont(new Font("Yu Gothic", Font.PLAIN, 9));
		txtCatalog1.setText("Citizens are encouraged to use or repurpose the City of Windsor's open data for research purposes or to improve their interaction with municipal services and facilities. Members of the community can use the raw data provided here to create and share resources from maps to applications and more. \n\nPlease be aware that by downloading or accessing this data, you agreet o be bound by the City of Windsor's Open Data Terms of Use.");
		txtCatalog1.setLineWrap(true);
		
		JLabel lbCatalog3 = new JLabel("Using Open Data");
		lbCatalog3.setBounds(67, 142, 220, 32);
		layeredPane.add(lbCatalog3);
		lbCatalog3.setFont(new Font("Yu Gothic", Font.BOLD, 24));
		
		JTextArea txtCatalog2 = new JTextArea();
		txtCatalog2.setBounds(67, 171, 660, 32);
		layeredPane.add(txtCatalog2);
		txtCatalog2.setEditable(false);
		txtCatalog2.setFont(new Font("Yu Gothic", Font.PLAIN, 9));
		txtCatalog2.setText("KMZ files can be imported to Google Maps, Google Earth or Bing maps. Download the instructions.\nAre you looking for JSON? Try our new swagger implementation https://opendata.citywindsor.ca/swagger");
		txtCatalog2.setWrapStyleWord(true);
		txtCatalog2.setLineWrap(true);
		
		JLabel lbCatalog4 = new JLabel("How can we improve the catalog?");
		lbCatalog4.setBounds(67, 208, 414, 42);
		layeredPane.add(lbCatalog4);
		lbCatalog4.setFont(new Font("Yu Gothic", Font.BOLD, 24));
		
		JTextArea txtCatalog3 = new JTextArea();
		txtCatalog3.setBounds(67, 238, 220, 22);
		layeredPane.add(txtCatalog3);
		txtCatalog3.setFont(new Font("Yu Gothic", Font.PLAIN, 9));
		txtCatalog3.setEditable(false);
		txtCatalog3.setText("Email us your suggestions, ideas, or questions.");
		
		JLabel lbFilter = new JLabel("Fliter by resource type:");
		lbFilter.setBounds(67, 270, 181, 20);
		layeredPane.add(lbFilter);
		lbFilter.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		
		txtKeyword = new JTextField();
		txtKeyword.setBounds(67, 341, 297, 19);
		layeredPane.add(txtKeyword);
		txtKeyword.setForeground(Color.BLACK);
		txtKeyword.setColumns(10);
		
		JLabel lbKeyword = new JLabel("Search Dataset by keyword:");
		lbKeyword.setBounds(67, 320, 181, 20);
		layeredPane.add(lbKeyword);
		lbKeyword.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		
		JLabel lbCheckboxes = new JLabel("Subject:");
		lbCheckboxes.setBounds(67, 370, 49, 20);
		layeredPane.add(lbCheckboxes);
		lbCheckboxes.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		
		JCheckBox checkbox1 = new JCheckBox("   Census");
		checkbox1.setBackground(new Color(255, 255, 255));
		checkbox1.setFont(new Font("Arial", Font.PLAIN, 12));
		checkbox1.setBounds(67, 384, 297, 21);
		layeredPane.add(checkbox1);
		
		JCheckBox checkbox2 = new JCheckBox("   Community Services");
		checkbox2.setFont(new Font("Arial", Font.PLAIN, 12));
		checkbox2.setBackground(Color.WHITE);
		checkbox2.setBounds(67, 407, 297, 21);
		layeredPane.add(checkbox2);
		
		JCheckBox checkbox3 = new JCheckBox("   Land and Construction");
		checkbox3.setFont(new Font("Arial", Font.PLAIN, 12));
		checkbox3.setBackground(Color.WHITE);
		checkbox3.setBounds(67, 430, 297, 21);
		layeredPane.add(checkbox3);
		
		JCheckBox checkbox4 = new JCheckBox("   Seasonal City Services");
		checkbox4.setFont(new Font("Arial", Font.PLAIN, 12));
		checkbox4.setBackground(Color.WHITE);
		checkbox4.setBounds(67, 453, 297, 21);
		layeredPane.add(checkbox4);
		
		JCheckBox checkbox5 = new JCheckBox("   Voting and Elections");
		checkbox5.setFont(new Font("Arial", Font.PLAIN, 12));
		checkbox5.setBackground(Color.WHITE);
		checkbox5.setBounds(67, 476, 297, 21);
		layeredPane.add(checkbox5);
		
		JCheckBox checkbox6 = new JCheckBox("   Waste and Waterworks");
		checkbox6.setFont(new Font("Arial", Font.PLAIN, 12));
		checkbox6.setBackground(Color.WHITE);
		checkbox6.setBounds(67, 499, 297, 21);
		layeredPane.add(checkbox6);
		
		JCheckBox checkbox7 = new JCheckBox("   Transportation");
		checkbox7.setFont(new Font("Arial", Font.PLAIN, 12));
		checkbox7.setBackground(Color.WHITE);
		checkbox7.setBounds(67, 522, 297, 21);
		layeredPane.add(checkbox7);
		
		JPanel dataSet = new JPanel();
		dataSet.setBorder(null);
		dataSet.setBackground(new Color(255, 255, 255));
		dataSet.setBounds(370, 370, 468, (int) (140 * Math.ceil(dataBaseSize / 2.0)));
		
		for (CatalogEntry entry: catalogEntries) {
			dataSet.add(addDataSet(entry.title, entry.description));
		}
		
		layeredPane.add(dataSet);
		dataSet.setLayout(new GridLayout(0, 2, 10, 10));
		
		JButton searchButton = new JButton("Search");
		searchButton.setBounds(67, 550, 85, 21);
		layeredPane.add(searchButton);
		
		JComboBox resourceFilter = new JComboBox();
		resourceFilter.setBounds(67, 289, 297, 21);
		layeredPane.add(resourceFilter);

		
		return contentPane;
	}

	/*
	 * addDataSet Method
	 * Last Updated: 2024-11-04
	 * Purpose: Adds and returns a new data set button given a label and an accompanying text
	 * Notes: the text can only handle up to 81 characters before it starts breaking. Title 39 characters.
	 * */
	public JPanel addDataSet(String label, String text) {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(471, 361, 261, 140);
		panel.setLayout(new GridLayout(2, 1, 0, 0));
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 0));
		
		
		JTextArea dataSetTitle = new JTextArea();
		dataSetTitle.setLineWrap(true);
		dataSetTitle.setEditable(false);
		dataSetTitle.setWrapStyleWord(true);
		dataSetTitle.setText(label);
		dataSetTitle.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		dataSetTitle.setBorder(new CompoundBorder(new LineBorder(Color.GRAY, 1), new EmptyBorder(5, 10, 5, 10)));
		dataSetTitle.setFocusable(false);
		panel.add(dataSetTitle);
		
		JTextArea dataSetDescription = new JTextArea();
		dataSetDescription.setWrapStyleWord(true);
		dataSetDescription.setLineWrap(true);
		dataSetDescription.setFont(new Font("Yu Gothic", Font.PLAIN, 10));
		dataSetDescription.setText(text);
		dataSetDescription.setBorder(new CompoundBorder(new LineBorder(Color.GRAY, 1), new EmptyBorder(5, 10, 5, 10)));
		dataSetDescription.setFocusable(false);
		panel.add(dataSetDescription);
		
	    // Add MouseListener to make it clickable
	    MouseAdapter clickListener = new MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent e) {
	            System.out.println("Dataset clicked: " + label);
	            // Add any action you want here, such as opening a detailed view.
	        }

	        @Override
	        public void mouseEntered(MouseEvent e) {
	            panel.setBackground(new Color(230, 230, 250)); // Change color on hover
	        }

	        @Override
	        public void mouseExited(MouseEvent e) {
	            panel.setBackground(Color.WHITE); // Reset color when not hovering
	        }
	    };
	    
	    panel.addMouseListener(clickListener);
	    dataSetTitle.addMouseListener(clickListener);
	    dataSetDescription.addMouseListener(clickListener);
	    
		return panel;
	}

    /**
     * Create the frame.
     */
    public JPanel Login() {
        setBounds(320, 180, 500, 400);
        
        // Panel setup
        contentPane = new JPanel();
        contentPane.setBackground(new Color(65, 105, 225)); // Updated color
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        // Title Label
        JLabel lblTitle = new JLabel("Login");
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 28));
        lblTitle.setBounds(200, 40, 100, 40);
        contentPane.add(lblTitle);

        // Username Label
        JLabel lblUsername = new JLabel("e-Mail Address or username");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblUsername.setForeground(Color.WHITE);
        lblUsername.setBounds(120, 100, 260, 30);
        contentPane.add(lblUsername);

        // Username TextField
        emailField = new JTextField();
        emailField.setBounds(120, 130, 260, 30);
        emailField.setToolTipText("Enter your email address");
        contentPane.add(emailField);
        emailField.setColumns(10);

        // Password Label
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblPassword.setForeground(Color.WHITE);
        lblPassword.setBounds(120, 170, 120, 30);
        contentPane.add(lblPassword);

        // Password Field
        passwordField = new JPasswordField();
        passwordField.setBounds(120, 200, 260, 30);
        passwordField.setToolTipText("Enter your password");
        contentPane.add(passwordField);

        // Login Button
        JButton btnLogin = new JButton("Log In");
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setBackground(new Color(76, 175, 80)); // Green background
        btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnLogin.setBounds(180, 250, 140, 40);
        btnLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnLogin.setBackground(new Color(56, 142, 60)); // Darker green on hover
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnLogin.setBackground(new Color(76, 175, 80));
            }
        });
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add login logic here
                System.out.println("Login button clicked");
            }
        });
        contentPane.add(btnLogin);

     // Create Account Label
        JLabel lblCreateAccount = new JLabel("Don't have an account? Create one");
        lblCreateAccount.setForeground(Color.WHITE);
        lblCreateAccount.setFont(new Font("Tahoma", Font.ITALIC, 14));
        lblCreateAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblCreateAccount.setBounds(140, 310, 240, 30); // Adjusted bounds for better alignment
        lblCreateAccount.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
			    setContentPane(CreateAccount());
			    
			    revalidate();
			    repaint();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            	lblCreateAccount.setForeground(Color.YELLOW); // Highlight on hover
                //lblCreateAccount.setForeground(new Color(173, 216, 230)); // Lighter blue on hover
            }
            @Override
            public void mouseExited(MouseEvent e) {
                lblCreateAccount.setForeground(Color.WHITE);
            }
        });
        contentPane.add(lblCreateAccount);

        // Close Button
        JLabel lblClose = new JLabel("X");
        lblClose.setToolTipText("Close");
        lblClose.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                lblClose.setForeground(Color.RED);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                lblClose.setForeground(new Color(139, 0, 0));
            }
        });
        lblClose.setForeground(new Color(139, 0, 0));
        lblClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblClose.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblClose.setBounds(470, 10, 20, 20);
        contentPane.add(lblClose);
        
        
        return contentPane;
    }
    

    /**
     * Create the frame.
     */
    public JPanel CreateAccount() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(320, 180, 500, 500);

        // Panel setup
        contentPane = new JPanel();
        contentPane.setBackground(new Color(65, 105, 225));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Title Label
        JLabel lblTitle = new JLabel("Create Account");
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 28));
        lblTitle.setBounds(131, 30, 266, 40);
        contentPane.add(lblTitle);

        // Email Label
        JLabel lblEmail = new JLabel("e-Mail Address");
        lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblEmail.setForeground(Color.WHITE);
        lblEmail.setBounds(120, 100, 260, 30);
        contentPane.add(lblEmail);

        // Email TextField
        emailField = new JTextField();
        emailField.setBounds(120, 130, 260, 30);
        emailField.setToolTipText("Enter your email address");
        contentPane.add(emailField);
        emailField.setColumns(10);

        // Username Label
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblUsername.setForeground(Color.WHITE);
        lblUsername.setBounds(120, 170, 260, 30);
        contentPane.add(lblUsername);

        // Username TextField
        usernameField = new JTextField();
        usernameField.setBounds(120, 200, 260, 30);
        usernameField.setToolTipText("Enter your username");
        contentPane.add(usernameField);
        usernameField.setColumns(10);

        // Password Label
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblPassword.setForeground(Color.WHITE);
        lblPassword.setBounds(120, 240, 120, 30);
        contentPane.add(lblPassword);

        // Password Field
        passwordField = new JPasswordField();
        passwordField.setBounds(120, 270, 260, 30);
        passwordField.setToolTipText("Enter your password");
        contentPane.add(passwordField);

        // Create Account Button
        JButton btnCreateAccount = new JButton("Create Account");
        btnCreateAccount.setForeground(Color.WHITE);
        btnCreateAccount.setBackground(new Color(76, 175, 80)); // Green background
        btnCreateAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnCreateAccount.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnCreateAccount.setBounds(150, 320, 201, 40);
        btnCreateAccount.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnCreateAccount.setBackground(new Color(56, 142, 60)); // Darker green on hover
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btnCreateAccount.setBackground(new Color(76, 175, 80));
            }
        });
        btnCreateAccount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add account creation logic here
                System.out.println("Create Account button clicked");
            }
        });
        contentPane.add(btnCreateAccount);

        // Login Label
        JLabel lblLogin = new JLabel("Already have an account? Log in here.");
        lblLogin.setForeground(Color.WHITE);
        lblLogin.setFont(new Font("Tahoma", Font.ITALIC, 14));
        lblLogin.setBounds(150, 380, 260, 30);
        lblLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
			    setContentPane(Login());
			    
			    revalidate();
			    repaint();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                lblLogin.setForeground(Color.YELLOW); // Highlight on hover
            }
            @Override
            public void mouseExited(MouseEvent e) {
                lblLogin.setForeground(Color.WHITE);
            }
        });
        contentPane.add(lblLogin);

        // Close Button
        JLabel lblClose = new JLabel("X");
        lblClose.setToolTipText("Close");
        lblClose.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                lblClose.setForeground(Color.RED);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                lblClose.setForeground(new Color(139, 0, 0));
            }
        });
        lblClose.setForeground(new Color(139, 0, 0));
        lblClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblClose.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblClose.setBounds(470, 10, 20, 20);
        contentPane.add(lblClose);
        
        return contentPane;
    }
}
