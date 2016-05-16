import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import com.toedter.calendar.JDateChooser;
/**
* @author Adam Minarik, Leonard Merva, Marek Dvoracek, Miroslav Fratric
*/
public class Test extends JFrame{
   private static final long serialVersionUID = 1L;
   private Hotel hotel;
   private JTabbedPane TopPanel;
   private JTabbedPane SearchPanel;
   private JLabel picture;
   private JPanel EastPanel;
   
   // LIST MODELS **********************************************
   private DefaultListModel actualFreeRoomsModel;
   private DefaultListModel freeRoomsModel;
   private DefaultListModel actualCheckedRooms;
   private DefaultListModel arrivalsModel;
   private DefaultListModel departuresModel;
   private DefaultListModel searchBookingsModel;
   private DefaultListModel searchPastGuestsModel;
   private DefaultListModel searchGuestsModel;
   
   
   // SPINNER MODELS *******************************************
   private SpinnerModel modelLaundry;
   private SpinnerModel modelRoomService;
   private SpinnerModel modelDays;
   private SpinnerModel roomsModel1;
   private SpinnerModel roomsModel2;
   private SpinnerModel roomsModel3;

   // BOOKING **************************************************
   private JButton SaveBK;
   private JButton ResetBK;
   private JButton ModifyBooking;
   private JLabel NameBKLabel;
   private JLabel SurnameBKLabel;
   private JLabel NationalityBKLabel;
   private JLabel PhoneNoBKLabel;
   private JLabel RoomBKLabel;
   private JLabel AddressBKLabel;
   private JLabel BirthdayBKLabel;
   private JLabel ArrivalBKLabel;
   private JLabel DepartureBKLabel;
   private JLabel DiscountBKLabel;
   private JLabel moverBK;
   private JLabel moverBK1;
   private JPanel CheckIn;
   private JPanel Booking;
   private JPanel CheckOut;
   private JPanel ArrDep;
   private JPanel TabContentBK;
   private JPanel ButtonsBK;
   private JCheckBox ExtraBedBK;
   private JTextField NameBK;
   private JTextField SurnameBK;
   private JTextField NationalityBK;
   private JTextField AddressBK;
   private JTextField PhoneNoBK;
   private JTextField RoomBK;
   private JTextField DiscountBK;
   private JDateChooser BirthdayBK;
   private JDateChooser ArrivalBK;
   private JDateChooser DepartureBK;
   // CHECK IN *************************************************
   private JLabel NameCILabel;
   private JLabel SurnameCILabel;
   private JLabel PhoneNoCILabel;
   private JLabel RoomCILabel;
   private JLabel AddressCILabel;
   private JLabel PassportCILabel;
   private JLabel EmailCILabel;
   private JLabel BirthdayCILabel;
   private JLabel ArrivalCILabel;
   private JLabel DepartureCILabel;
   private JLabel DiscountCILabel;
   private JLabel mover;
   private JLabel mover2;
   private JPanel ButtonsCI;
   private JCheckBox ExtraBedCI;
   private JButton SaveCI;
   private JButton ResetCI;
   private JPanel TabContentCI;
   private JTextField NameCI;       
   private JTextField SurnameCI;
   private JTextField AddressCI;
   private JTextField PhoneNoCI;
   private JTextField RoomCI;
   private JTextField PassportCI;
   private JTextField EmailCI;
   private JTextField DiscountCI;
   private JDateChooser BirthdayCI;
   private JDateChooser ArrivalCI;
   private JDateChooser DepartureCI;
  //CHECK OUT *****************************************
    private JPanel CheckOutButtons;
    private JPanel CheckOutCheckBoxes;
    private JList CheckOutList;
    private JButton CheckOutButton;
    private JButton RefreshButton;
    private JCheckBox MiniBar;
    private JCheckBox Laundry;
    private JCheckBox RoomService;
    private JLabel MiniBarLabel;
    private JTextField MiniBarPrice;
    private JSpinner LaundrySpinner;
    private JSpinner RoomServiceSpinner;
    private JLabel TotalDaysLabel;
    private JSpinner TotalDaysSpinner;
    private JScrollPane CheckOutListPane;
    
    
 
  //SEARCH *********************************************
   
   private JPanel SearchContent;
   private JPanel SearchGuests;
   private JPanel SearchPastGuests;
   private JPanel SearchBookings;
   private JPanel ShowFreeRooms;
   private JPanel SearchRooms;
   private JTextField SearchName;
   private JTextField SearchRoomNo;
      //Free rooms ****************************
      private JLabel AvailableRoomsLabel;
      private JList<String> AvailableRoomsList;
      private JScrollPane AvailableRoomsListPane;
      
      //SEARCH Free rooms ******************************
      private JPanel FreeRoomsContent;
      private JPanel FreeRoomsList;
      private JPanel FreeRoomsButtons;
      private JDateChooser SearchArrDate;
      private JDateChooser SearchDepDate;
      private JLabel SearchArrDateLabel;
      private JLabel SearchDepDateLabel;
      private JList<String> SearchRoomsList;
      private JButton SearchButtonRooms;
      private JButton ResetButtonRooms;
      private JScrollPane SearchRoomsScroll;
      //SEARCH Bookings ********************************
      private JPanel SearchBookingsButtons;
      private JPanel SearchBookingsContent;
      private JDateChooser SearchBookingsDate;
      private JLabel SearchBookingsDateLabel;
      private JLabel SearchBookingsNameLabel;
      private JTextField SearchBookingNameText;
      private JSpinner SearchBookingRoomNo;
      private JLabel SearchBookingRoomNoLabel;
      private JList SearchBookingsJList;
      private JButton SearchBookingsButton;
      private JButton SearchBookingsCheckIn;
      private JButton CancelBookingButton;
      private JTextField SearchBookingSurnameText;
      private JLabel SearchBookingsSurnameLabel;
      private JScrollPane SearchBookingsJListPane;
      
      //SEARCH PastGuests ******************************
      private JPanel SearchPastGuestsButtons;
      private JPanel SearchPastGuestsContent;
      private JList SearchPastGuestsList;
      private JLabel SearchPastGuestsNameLabel;
      private JLabel SearchPastGuestsSurnameLabel;
      private JTextField SearchPastGuestsNameText;
      private JTextField SearchPastGuestsSurnameText;
      private JButton SearchPastGuestsSearchButton;
      private JButton SearchPastGuestsRefreshButton;
      private JScrollPane SearchPastGuestsListPane;
      
      //SEARCH guests
      private JPanel SearchGuestsButtons;
      private JPanel SearchGuestsContent;
      private JList SearchGuestsList;
      private JLabel SearchGuestsRoomsLabel;
      private JLabel SearchGuestsNameLabel;
      private JLabel SearchGuestsSurnameLabel;
      private JTextField SearchGuestsNameText;
      private JTextField SearchGuestsSurnameText;
      private JSpinner SearchGuestsRoomsSpinner;
      private JButton SearchGuestsRoomsButton;
      private JButton ClearGuestsRoomsButton;
      private JScrollPane SearchGuestsListPane;
      
   //ARRIVALS-DEPARTURES *******************************
   private JPanel ArrivalsDepartures;
   private JPanel ArrivalsContent;
   private JPanel DeparturesContent;
   private JPanel ArrDepButtons;
   private JList<String> Arrivals;
   private JList<String> Departures;
   private JScrollPane ArrivalsScroll;
   private JScrollPane DeparturesScroll;
   private JButton RefreshArrDep;

   
   public Test(Hotel hotel) throws Exception{
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      this.hotel = hotel;
      setTitle("Deer Alley Hotel");
      setLayout(new BorderLayout());
      hotel.functions().createResFolder();
      hotel.functions().readDataFromFiles(hotel);
      setComponents();
      addComponents();
      addPanelsAndLayouts();
      setBorders();
      getFreeRooms();
      getAllPastGuests();
      
      SaveCI.addActionListener(new CheckIn());
      ResetCI.addActionListener(new ResetCI());
      RefreshButton.addActionListener(new RefreshCheckOut());
      SearchButtonRooms.addActionListener(new SearchFreeRooms());
      CheckOutButton.addActionListener(new CheckOut());
      RefreshArrDep.addActionListener(new ArrDepRefresh());
      SearchBookingsButton.addActionListener(new SearchBookings());
      SearchPastGuestsSearchButton.addActionListener(new searchPastGuests());
      SearchPastGuestsRefreshButton.addActionListener(new refreshPastGuests());
      SearchBookingsCheckIn.addActionListener(new checkInFromBooking());
      SearchGuestsRoomsButton.addActionListener(new SearchGuests());
      CancelBookingButton.addActionListener(new CancelBooking());
      ClearGuestsRoomsButton.addActionListener(new SearchGuestsClear());
      ModifyBooking.addActionListener(new modifyBooking());
      
      SaveBK.addActionListener(new Booking());
      ResetBK.addActionListener(new ResetBK());
      
      pack();
   }

   private void addPanelsAndLayouts(){
      CheckIn.setLayout(new BorderLayout());
      Booking.setLayout(new BorderLayout());
      CheckOut.setLayout(new BorderLayout());
      ArrDep.setLayout(new BorderLayout());
      SearchContent.setLayout(new BorderLayout());
      ArrivalsDepartures.setLayout(new BorderLayout());
      ArrivalsContent.setLayout(new BorderLayout());
      DeparturesContent.setLayout(new BorderLayout());
      
      SearchRooms.setLayout(new BorderLayout());
      FreeRoomsList.setLayout(new BorderLayout());
      SearchBookings.setLayout(new BorderLayout());
      SearchPastGuests.setLayout(new BorderLayout());
      SearchGuests.setLayout(new BorderLayout());
      
      SearchGuestsContent.setLayout(new GridLayout(3,2));
      SearchPastGuestsContent.setLayout(new GridLayout(2,2));
      SearchBookingsContent.setLayout(new GridLayout(4,2));
      CheckOutCheckBoxes.setLayout(new GridLayout(2,1));
      FreeRoomsContent.setLayout(new GridLayout(2,2));
      ShowFreeRooms.setLayout(new BorderLayout());
      TabContentCI.setLayout(new GridLayout(13,2));
      TabContentBK.setLayout(new GridLayout(12,2));
      
      
      add(EastPanel, BorderLayout.EAST);
      EastPanel.add(picture);
      
      //TABS ****************************************************
      add(TopPanel, BorderLayout.WEST);
      Booking.add(TabContentBK,BorderLayout.NORTH);
      Booking.add(ButtonsBK, BorderLayout.SOUTH);
      CheckIn.add(TabContentCI, BorderLayout.NORTH);
      CheckIn.add(ButtonsCI,BorderLayout.SOUTH);
      ArrDep.add(ArrivalsDepartures, BorderLayout.NORTH);
      
      
      //CHECKOUT ************************************************
      CheckOut.add(CheckOutListPane,BorderLayout.CENTER);
      CheckOut.add(CheckOutButtons,BorderLayout.SOUTH);
      CheckOut.add(CheckOutCheckBoxes,BorderLayout.NORTH);
      

      CheckOutButtons.add(CheckOutButton);
      CheckOutButtons.add(RefreshButton);
      CheckOutCheckBoxes.add(MiniBar);
      CheckOutCheckBoxes.add(MiniBarPrice);
      CheckOutCheckBoxes.add(Laundry);
      CheckOutCheckBoxes.add(LaundrySpinner);
      CheckOutCheckBoxes.add(RoomService);
      CheckOutCheckBoxes.add(RoomServiceSpinner);
      CheckOutCheckBoxes.add(TotalDaysLabel);
      CheckOutCheckBoxes.add(TotalDaysSpinner);
      
      //SEARCH **************************************************
      add(SearchPanel, BorderLayout.CENTER);
         
         //Free rooms *******************************************
         ShowFreeRooms.add(AvailableRoomsLabel, BorderLayout.NORTH);
         ShowFreeRooms.add(AvailableRoomsListPane, BorderLayout.CENTER);
         
         //SEARCH free rooms ************************************
         FreeRoomsContent.add(SearchArrDateLabel);
         FreeRoomsContent.add(SearchArrDate);
         FreeRoomsContent.add(SearchDepDateLabel);
         FreeRoomsContent.add(SearchDepDate);
         FreeRoomsList.add(SearchRoomsScroll);
         FreeRoomsButtons.add(SearchButtonRooms);
         FreeRoomsButtons.add(ResetButtonRooms);
         SearchRooms.add(FreeRoomsList, BorderLayout.CENTER);
         SearchRooms.add(FreeRoomsContent,BorderLayout.NORTH);
         SearchRooms.add(FreeRoomsButtons, BorderLayout.SOUTH);
         
         //SEARCH Bookings
         SearchBookings.add(SearchBookingsButtons, BorderLayout.SOUTH);
         SearchBookings.add(SearchBookingsContent, BorderLayout.NORTH);
         SearchBookings.add(SearchBookingsJListPane, BorderLayout.CENTER);
         
         SearchBookingsButtons.add(SearchBookingsCheckIn);
         SearchBookingsButtons.add(SearchBookingsButton);
         SearchBookingsButtons.add(CancelBookingButton);
         SearchBookingsButtons.add(ModifyBooking);
         SearchBookingsContent.add(SearchBookingsDateLabel);
         SearchBookingsContent.add(SearchBookingsDate);
         SearchBookingsContent.add(SearchBookingsNameLabel);
         SearchBookingsContent.add(SearchBookingNameText);
         SearchBookingsContent.add(SearchBookingsSurnameLabel);
         SearchBookingsContent.add(SearchBookingSurnameText);
         SearchBookingsContent.add(SearchBookingRoomNoLabel);
         SearchBookingsContent.add(SearchBookingRoomNo);
         
         //SEARCH pastguests ************************************
         SearchPastGuests.add(SearchPastGuestsContent, BorderLayout.NORTH);
         SearchPastGuests.add(SearchPastGuestsListPane, BorderLayout.CENTER);
         SearchPastGuests.add(SearchPastGuestsButtons, BorderLayout.SOUTH);
       
         SearchPastGuestsButtons.add(SearchPastGuestsSearchButton);
         SearchPastGuestsButtons.add(SearchPastGuestsRefreshButton);
         SearchPastGuestsContent.add(SearchPastGuestsNameLabel);
         SearchPastGuestsContent.add(SearchPastGuestsNameText);
         SearchPastGuestsContent.add(SearchPastGuestsSurnameLabel);
         SearchPastGuestsContent.add(SearchPastGuestsSurnameText);
         
         //SEARCH guests ****************************************
         SearchGuests.add(SearchGuestsButtons, BorderLayout.SOUTH);
         SearchGuests.add(SearchGuestsContent, BorderLayout.NORTH);
         SearchGuests.add(SearchGuestsListPane, BorderLayout.CENTER);
         
         SearchGuestsButtons.add(SearchGuestsRoomsButton);
         SearchGuestsButtons.add(ClearGuestsRoomsButton);
         SearchGuestsContent.add(SearchGuestsNameLabel);
         SearchGuestsContent.add(SearchGuestsNameText);
         SearchGuestsContent.add(SearchGuestsSurnameLabel);
         SearchGuestsContent.add(SearchGuestsSurnameText);
         SearchGuestsContent.add(SearchGuestsRoomsLabel);
         SearchGuestsContent.add(SearchGuestsRoomsSpinner);
         
         
      //ARRIVALS-DEPARTURES *************************************
      
      ArrivalsDepartures.add(ArrivalsContent, BorderLayout.NORTH);
      ArrivalsDepartures.add(DeparturesContent, BorderLayout.CENTER);
      ArrivalsDepartures.add(ArrDepButtons, BorderLayout.SOUTH);
      
      ArrDepButtons.add(RefreshArrDep);
      ArrivalsContent.add(ArrivalsScroll);
      
      DeparturesContent.add(DeparturesScroll);
      
   }

   private void setComponents(){
	   picture = new JLabel();
	   picture.setIcon(new ImageIcon(getClass().getResource("logoEast.png").getFile()));
	   
	   mover = new JLabel();
	   mover2 = new JLabel();
	   moverBK = new JLabel();
	   moverBK1 = new JLabel();
	   EastPanel = new JPanel();
	  
	  // SPINNER MODELS *******************************************
	   modelLaundry = new SpinnerNumberModel(0, 0, 100, 1);
	   modelRoomService = new SpinnerNumberModel(0, 0, 31, 1);
	   modelDays = new SpinnerNumberModel(0, 0, 31, 1);
	   roomsModel1 = new SpinnerNumberModel(0, 0, 25, 1);
	   roomsModel2 = new SpinnerNumberModel(0, 0, 25, 1);
	   roomsModel3 = new SpinnerNumberModel(0, 0, 25, 1);
	   
      //MODELS *******************************************************
      actualFreeRoomsModel = new DefaultListModel();
      freeRoomsModel = new DefaultListModel();
      actualCheckedRooms = new DefaultListModel();
      arrivalsModel = new DefaultListModel();
      departuresModel = new DefaultListModel();
      searchBookingsModel = new DefaultListModel();
      searchPastGuestsModel = new DefaultListModel();
      searchGuestsModel = new DefaultListModel();
      //PANELS *******************************************************
      TopPanel = new JTabbedPane();
      SearchPanel = new JTabbedPane();
      ButtonsCI = new JPanel();
      CheckIn = new JPanel();
      Booking = new JPanel();
      CheckOut = new JPanel();
      ArrDep = new JPanel();
      TabContentCI = new JPanel();
      SearchContent = new JPanel();
      
      //BOOKING ******************************************************
      TabContentBK = new JPanel();
      ButtonsBK = new JPanel();
      NameBKLabel = new JLabel("Name: ");
      SurnameBKLabel = new JLabel("Surname: ");
      NationalityBKLabel = new JLabel("Nationality: ");
      RoomBKLabel = new JLabel("Room: ");
      AddressBKLabel = new JLabel("Address: ");
      PhoneNoBKLabel = new JLabel("Phone Number: ");
      ArrivalBKLabel = new JLabel("Arrival date: ");
      DepartureBKLabel = new JLabel("Departure date: ");
      BirthdayBKLabel = new JLabel("Birthday: ");
      ExtraBedBK = new JCheckBox("Extra bed");
      DiscountBKLabel = new JLabel("Discount: ");
     
      NameBK = new JTextField("Enter name");
      SurnameBK = new JTextField("Enter surname");
      NationalityBK = new JTextField("Enter nationality");
      AddressBK = new JTextField("Enter address");
      PhoneNoBK = new JTextField("Enter phone number");
      RoomBK = new JTextField("Enter room");
      DiscountBK = new JTextField("0");
      
      BirthdayBK = new JDateChooser();
      ArrivalBK = new JDateChooser();
      DepartureBK = new JDateChooser();
      
      SaveBK = new JButton("Create booking");
      ResetBK = new JButton("Reset");
      ModifyBooking = new JButton("Modify booking");
      
      //CHECK-IN *****************************************************
      NameCILabel = new JLabel("Name: ");
      SurnameCILabel = new JLabel("Surname: ");
      RoomCILabel = new JLabel("Room: ");
      AddressCILabel = new JLabel("Address: ");
      PhoneNoCILabel = new JLabel("Phone Number: ");
      PassportCILabel = new JLabel("Passport: ");
      EmailCILabel = new JLabel("E-mail: ");
      ArrivalCILabel = new JLabel("Arrival date: ");
      DepartureCILabel = new JLabel("Departure date: ");
      BirthdayCILabel = new JLabel("Birthday: ");
      ExtraBedCI = new JCheckBox("Extra bed");
      DiscountCILabel = new JLabel("Discount: ");
      
      NameCI = new JTextField("Enter name");
      SurnameCI = new JTextField("Enter surname");
      AddressCI = new JTextField("Enter address");
      PhoneNoCI = new JTextField("Enter phone number");
      RoomCI = new JTextField("Enter room");
      PassportCI = new JTextField("Enter passport");
      EmailCI = new JTextField("Enter e-mail");
      DiscountCI = new JTextField("0");
      
      BirthdayCI = new JDateChooser();
      ArrivalCI = new JDateChooser();
      DepartureCI = new JDateChooser();
      
      SaveCI = new JButton("Check-in guest");
      ResetCI = new JButton("Reset");
      
      //CHECKOUT **************************************
      CheckOutButtons = new JPanel();
      CheckOutCheckBoxes = new JPanel();
      CheckOutList = new JList(actualCheckedRooms);
      CheckOutButton = new JButton("Check-out");
      RefreshButton = new JButton("Refresh");
      MiniBar = new JCheckBox("Mini bar");
      Laundry = new JCheckBox("Laundry");
      RoomService = new JCheckBox("Room service");
      MiniBarPrice = new JTextField("Enter price");
      MiniBarLabel = new JLabel("Mini bar price: ");
      LaundrySpinner = new JSpinner(modelLaundry);
      RoomServiceSpinner = new JSpinner(modelRoomService);
      TotalDaysLabel = new JLabel("  Number of nights: ");
      TotalDaysSpinner = new JSpinner(modelDays);
      CheckOutListPane = new JScrollPane(CheckOutList);
      //SEARCH ****************************************
      SearchName = new JTextField("Enter name");
      SearchRoomNo = new JTextField("Enter room number");
      SearchContent = new JPanel();
      SearchGuests = new JPanel();
      SearchPastGuests = new JPanel();
      SearchBookings = new JPanel();
      ShowFreeRooms = new JPanel();
      SearchRooms = new JPanel();
  
         //Free rooms *********************************
         AvailableRoomsLabel = new JLabel("All available rooms: ");
         AvailableRoomsList = new JList<String>(actualFreeRoomsModel);    
         AvailableRoomsListPane = new JScrollPane(AvailableRoomsList);
         
         //SEARCH free rooms **************************
         FreeRoomsContent = new JPanel();
         FreeRoomsButtons = new JPanel();
         FreeRoomsList = new JPanel();
         SearchArrDateLabel = new JLabel("Arrival date: ");
         SearchDepDateLabel = new JLabel("Departure date: ");
         SearchArrDate = new JDateChooser();
         SearchDepDate = new JDateChooser();
         SearchRoomsList = new JList(freeRoomsModel);  
         SearchButtonRooms = new JButton("Search");
         ResetButtonRooms = new JButton("Reset");
         SearchRoomsScroll = new JScrollPane(SearchRoomsList);
        
         //SEARCH search bookings *********************
         SearchBookingsButtons = new JPanel();
         SearchBookingsContent = new JPanel();;
         SearchBookingsDate = new JDateChooser();
         SearchBookingsDateLabel = new JLabel("Date: ");
         SearchBookingsNameLabel = new JLabel("Guest name: ");
         SearchBookingNameText = new JTextField("Enter name");
         SearchBookingRoomNo = new JSpinner(roomsModel1);
         SearchBookingRoomNoLabel = new JLabel("Room number: ");
         SearchBookingsButton = new JButton("Search");
         SearchBookingsJList = new JList(searchBookingsModel);
         SearchBookingsCheckIn = new JButton("Create check-in");
         CancelBookingButton = new JButton("Cancel booking");
         SearchBookingsSurnameLabel = new JLabel("Guest surname: ");
         SearchBookingSurnameText = new JTextField("Enter surname");
         SearchBookingsJListPane = new JScrollPane(SearchBookingsJList);
         //SEARCH past guests *************************
         SearchPastGuestsContent = new JPanel();
         SearchPastGuestsButtons = new JPanel();
         SearchPastGuestsList = new JList(searchPastGuestsModel);
         SearchPastGuestsNameLabel = new JLabel("Name: ");
         SearchPastGuestsSurnameLabel = new JLabel ("Surname: ");
         SearchPastGuestsNameText = new JTextField("Enter name");
         SearchPastGuestsSurnameText = new JTextField("Enter surname");
         SearchPastGuestsSearchButton = new JButton("Search");
         SearchPastGuestsRefreshButton = new JButton("Refresh");
         SearchPastGuestsListPane = new JScrollPane(SearchPastGuestsList);
         
         //SEARCH guests ******************************
         SearchGuestsButtons = new JPanel();
         SearchGuestsContent = new JPanel();
         SearchGuestsList = new JList(searchGuestsModel);
         SearchGuestsRoomsLabel = new JLabel("Room number: ");
         SearchGuestsRoomsSpinner = new JSpinner(roomsModel2);
         SearchGuestsNameLabel = new JLabel("Name: ");
         SearchGuestsSurnameLabel = new JLabel("Surname: ");
         SearchGuestsNameText = new JTextField("Enter name");
         SearchGuestsSurnameText = new JTextField("Enter surname");
         SearchGuestsRoomsButton = new JButton("Search");
         ClearGuestsRoomsButton = new JButton("Clear");
         SearchGuestsListPane = new JScrollPane(SearchGuestsList);
         
         
   
      //ARRIVALS-DEPARTURE ****************************
      ArrivalsDepartures = new JPanel();
      ArrivalsContent = new JPanel();
      DeparturesContent = new JPanel();
      ArrDepButtons = new JPanel();
      Arrivals = new JList(arrivalsModel);
      Departures = new JList(departuresModel);
      ArrivalsScroll = new JScrollPane(Arrivals);
      DeparturesScroll = new JScrollPane(Departures);
      RefreshArrDep = new JButton("Refresh");
      
   }
   
   private void addComponents(){
      //Tabs(Booking, Check-in....) ********************
      TopPanel.addTab("Booking", Booking);
      TopPanel.addTab("Check In", CheckIn);
      TopPanel.addTab("Check Out", CheckOut);
      TopPanel.addTab("Arrivals/Departures", ArrDep);
      
      //Tabs(Search) ***********************************
      SearchPanel.addTab("Actual free rooms", ShowFreeRooms);
      SearchPanel.addTab("Search for free rooms", SearchRooms);
      SearchPanel.addTab("Search bookings", SearchBookings);
      SearchPanel.addTab("Search past guests", SearchPastGuests);
      SearchPanel.addTab("Search guests", SearchGuests);
      
      
      //Check-in ***************************************
      TabContentCI.add(NameCILabel);
      TabContentCI.add(NameCI);
      TabContentCI.add(SurnameCILabel);
      TabContentCI.add(SurnameCI);
      TabContentCI.add(AddressCILabel);
      TabContentCI.add(AddressCI);
      TabContentCI.add(PhoneNoCILabel);
      TabContentCI.add(PhoneNoCI);
      TabContentCI.add(RoomCILabel);
      TabContentCI.add(RoomCI);
      TabContentCI.add(PassportCILabel);
      TabContentCI.add(PassportCI);
      TabContentCI.add(EmailCILabel);
      TabContentCI.add(EmailCI);
      TabContentCI.add(BirthdayCILabel);
      TabContentCI.add(BirthdayCI);
      TabContentCI.add(ArrivalCILabel);
      TabContentCI.add(ArrivalCI);
      TabContentCI.add(DepartureCILabel);
      TabContentCI.add(DepartureCI);
      TabContentCI.add(mover);
      TabContentCI.add(mover2);
      TabContentCI.add(DiscountCILabel);
      TabContentCI.add(DiscountCI);
      TabContentCI.add(ExtraBedCI);
      ButtonsCI.add(SaveCI);
      ButtonsCI.add(ResetCI);
      
      //Booking ****************************************
      TabContentBK.add(NameBKLabel);
      TabContentBK.add(NameBK);
      TabContentBK.add(SurnameBKLabel);
      TabContentBK.add(SurnameBK);
      TabContentBK.add(NationalityBKLabel);
      TabContentBK.add(NationalityBK);
      TabContentBK.add(AddressBKLabel);
      TabContentBK.add(AddressBK);
      TabContentBK.add(PhoneNoBKLabel);
      TabContentBK.add(PhoneNoBK);
      TabContentBK.add(RoomBKLabel);
      TabContentBK.add(RoomBK);
      TabContentBK.add(BirthdayBKLabel);
      TabContentBK.add(BirthdayBK);
      TabContentBK.add(ArrivalBKLabel);
      TabContentBK.add(ArrivalBK);
      TabContentBK.add(DepartureBKLabel);
      TabContentBK.add(DepartureBK);
      TabContentBK.add(moverBK);
      TabContentBK.add(moverBK1);
      TabContentBK.add(DiscountBKLabel);
      TabContentBK.add(DiscountBK);
      TabContentBK.add(ExtraBedBK);
      ButtonsBK.add(SaveBK);
      ButtonsBK.add(ResetBK);
   }

   public void setBorders() {
      ArrivalsContent.setBorder(BorderFactory.createTitledBorder("Arrivals"));
      DeparturesContent.setBorder(BorderFactory.createTitledBorder("Departures"));
      TopPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
      SearchPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 10));
      AvailableRoomsLabel.setBorder(BorderFactory.createEmptyBorder(0,0,8,0));
      CheckOut.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
      CheckIn.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
      Booking.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
      ArrDep.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
      SearchContent.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
      SearchGuests.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
      SearchPastGuests.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
      SearchBookings.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
      ShowFreeRooms.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
      SearchRooms.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
      FreeRoomsContent.setBorder(BorderFactory.createEmptyBorder(0,0,8,0));
      SearchBookingsContent.setBorder(BorderFactory.createEmptyBorder(0,0,8,0));
      SearchPastGuestsContent.setBorder(BorderFactory.createEmptyBorder(0,0,8,0));
      SearchGuestsContent.setBorder(BorderFactory.createEmptyBorder(0,0,8,0));
      CheckOutCheckBoxes.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
   }
// ACTION LISTENERS ****************************************************
	
   class Booking implements ActionListener{
      @SuppressWarnings("deprecation")
      public void actionPerformed(ActionEvent e)
      {
         fillCheckerBooking();
         int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
         String name = NameBK.getText();
         String surname = SurnameBK.getText();
         String nationality = NationalityBK.getText();
         String address = AddressBK.getText();
         long phoneNo = Long.parseLong(PhoneNoBK.getText());
         int room = Integer.parseInt(RoomBK.getText());
         double discount = Double.parseDouble(DiscountBK.getText());
         Date bd = BirthdayBK.getDate();
         String birthday = bd.getDate() + "/" + (bd.getMonth() + 1) + "/" + (bd.getYear() + 1900);
         Date ar = ArrivalBK.getDate();
         String arrival = ar.getDate() + "/" + (ar.getMonth() + 1)  + "/" + (ar.getYear() + 1900);
         Date dp = DepartureBK.getDate();
         String departure = dp.getDate() + "/" + (dp.getMonth() + 1)  + "/" + (dp.getYear() + 1900);
         BookingGuest temporaryGuest = new BookingGuest(name, surname, address, phoneNo, birthday, nationality, arrival,  departure, room, discount);
         
         hotel.functions().countDatesFromInput(dp, ar);
         
         int counter = 1;
         if(Test.this.equals(hotel.getAllAccomodations().get(room - 1).getBookedDays(), hotel.functions().getTempArrayList())){
            for(int i=0; i< hotel.functions().getDays(); i++){
               if(ar.getDate() + i <= months[ar.getMonth()]){
                  hotel.getAllAccomodations().get(room-1).addBookedDay((ar.getDate()+i) + "/" + (ar.getMonth() + 1) + "/" + (ar.getYear() + 1900));
               }
               else{
                  hotel.getAllAccomodations().get(room -1).addBookedDay(counter + "/" + (dp.getMonth()+1) + "/" + (dp.getYear() + 1900));
                  counter++;
               }
            }
           hotel.bookGuestToRoom(room - 1, temporaryGuest);
           JOptionPane.showMessageDialog(TabContentBK, "Booking successful!");
           resetBK();
           if(ExtraBedBK.isSelected()){
              hotel.getAllAccomodations().get(room - 1).extraBedPrice(30);
           }
         }else{
            JOptionPane.showMessageDialog(TabContentBK, "Date already booked!");
         }
         try{
            hotel.functions().inputDataToFiles(hotel);
         }catch (Exception e1){
            e1.printStackTrace();
         }
      }
   }
   
   
   class CheckIn implements ActionListener {
      @SuppressWarnings("deprecation")
      public void actionPerformed(ActionEvent e)
      {
         fillCheckerCheckIn();
         int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
         String name = NameCI.getText();
         String surname = SurnameCI.getText();
         String address = AddressCI.getText();
         long phoneNo = Long.parseLong(PhoneNoCI.getText());
         int room = Integer.parseInt(RoomCI.getText());
         double discount = Double.parseDouble(DiscountCI.getText());
         String passport = PassportCI.getText();
         String email = EmailCI.getText();
         Date bd = BirthdayCI.getDate();
         String birthday = bd.getDate() + "/" + (bd.getMonth() + 1) + "/" + (bd.getYear() + 1900);
         Date ar = ArrivalCI.getDate();
         String arrival = ar.getDate() + "/" + (ar.getMonth() + 1)  + "/" + (ar.getYear() + 1900);
         Date dp = DepartureCI.getDate();
         String departure = dp.getDate() + "/" + (dp.getMonth() + 1)  + "/" + (dp.getYear() + 1900);
         CheckInGuest temporaryGuest = new CheckInGuest(name, surname, address, phoneNo, birthday, arrival, departure, email, passport, room);
         
         hotel.functions().countDatesFromInput(dp, ar);
         
         int counter = 1;
         if(hotel.getAllAccomodations().get(room-1).getCheckedGuests().size() == 0) {
            for(int i=0; i< hotel.functions().getDays(); i++){
               if(ar.getDate() + i <= months[ar.getMonth()]){
                  hotel.getAllAccomodations().get(room-1).addCheckedDay((ar.getDate()+i) + "/" + (ar.getMonth() + 1) + "/" + (ar.getYear() + 1900));
               }else{
                  hotel.getAllAccomodations().get(room -1).addCheckedDay(counter + "/" + (dp.getMonth()+1) + "/" + (dp.getYear() + 1900));
                  counter++;
               }
             }
         }
         if(hotel.getAllAccomodations().get(room-1).getCheckedGuests().size() < hotel.getAllAccomodations().get(room-1).getMaxGuests()) {   
           hotel.checkInGuestToRoom(room - 1, temporaryGuest);
           hotel.getAllAccomodations().get(room - 1).setDiscount(discount);
           JOptionPane.showMessageDialog(TabContentCI, "Check-in was successful!");
           updateFreeRooms();
           if(ExtraBedCI.isSelected()){
              hotel.getAllAccomodations().get(room -1).extraBedPrice(30);
              hotel.getAllAccomodations().get(room - 1).setMaxGuests((hotel.getAllAccomodations().get(room - 1).getMaxGuests() + 1));
           }
         }else{
            JOptionPane.showMessageDialog(TabContentCI, "Room number: " + room + " is full!");
         }try{
            hotel.functions().inputDataToFiles(hotel);
         }catch (Exception e1){
            e1.printStackTrace();
         }
         resetCI();
      
      }
   }
   
   class SearchFreeRooms implements ActionListener {
      @SuppressWarnings("deprecation")
   public void actionPerformed(ActionEvent e) {
      freeRoomsModel.clear();
      for(int i = 0; i < hotel.getAllAccomodations().size(); i++) {
         freeRoomsModel.addElement(hotel.getAllAccomodations().get(i));
      }
       int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
       int days = 0;
       ArrayList <String> temp = new ArrayList<>();
      
        Date ar = SearchArrDate.getDate();
        String arrival = ar.getDate() + "/" + (ar.getMonth() + 1)  + "/" + (ar.getYear() + 1900);
        Date dp = SearchDepDate.getDate();
        String departure = dp.getDate() + "/" + (dp.getMonth() + 1)  + "/" + (dp.getYear() + 1900);
        
        if(dp.getYear()>ar.getYear()){
            days = (dp.getDate()+31) - ar.getDate();
         }
         else if(dp.getMonth()>ar.getMonth()){
            if(ar.getMonth()+1 == 2){
              if(ar.getYear() % 400 == 0 || ar.getYear() % 4 == 0  ){
                days = (dp.getDate()+29) - ar.getDate();
              }else{
                days = (dp.getDate()+28) - ar.getDate();
              }
            }
            else if((ar.getMonth()+1) % 2 == 0 && (ar.getMonth() + 1) < 7){
               days = (dp.getDate()+30) - ar.getDate();
            }
            else if((ar.getMonth()+1) % 2 == 0 && (ar.getMonth() + 1) >= 7){
               days = (dp.getDate()+31) - ar.getDate();
            }
            else if((ar.getMonth()+1) % 2 != 0 && (ar.getMonth() + 1) <= 7){
               days = (dp.getDate()+31) - ar.getDate();
            }
            else if((ar.getMonth()+1) % 2 != 0 && (ar.getMonth() + 1) > 7){
               days = (dp.getDate()+30) - ar.getDate();
            }
         }else{
            days = dp.getDate() - ar.getDate();
         }
         int counter = 1;
         for(int i=0; i<days; i++){
            if(ar.getDate() + i <= months[ar.getMonth()]){
               temp.add((ar.getDate()+i) + "/" + (ar.getMonth() + 1) + "/" + (ar.getYear() + 1900));
            }
            else{
               temp.add(counter + "/" + (dp.getMonth()+1) + "/" + (dp.getYear() + 1900));
               counter++;
            }
         }
         counter = 1;
        
        int countOff = 0;
        for(int i = 0; i < hotel.getAllAccomodations().size(); i++) {
         goingThroughDays:
         for(int j = 0; j < hotel.getAllAccomodations().get(i).getBookedDays().size(); j++) {
            for(int k = 0; k < temp.size(); k++){
               if(hotel.getAllAccomodations().get(i).getBookedDays().get(j).equals(temp.get(k))) {
                  freeRoomsModel.remove(i-countOff);
                  countOff++;
                  break goingThroughDays;
               }
            }
         }
         goingThroughCheckDays:
         for(int j = 0; j < hotel.getAllAccomodations().get(i).getCheckedDays().size(); j++) {
            for(int k = 0; k < temp.size(); k++){
               if( hotel.getAllAccomodations().get(i).getCheckedDays().get(j).equals(temp.get(k))) {
                  freeRoomsModel.remove(i-countOff);
                  countOff++;
                  break goingThroughCheckDays;
               }
            }
         }
        }
     }  
   }
   
   class SearchBookings implements ActionListener{
      @Override
      @SuppressWarnings("deprecation")
      public void actionPerformed(ActionEvent e)
      {
         //Search for Bookings by Date ***********************************
         if(SearchBookingsDate.getDate() != null){
         searchBookingsModel.clear();
         Date dt = SearchBookingsDate.getDate();
         String date = dt.getDate() + "/" + (dt.getMonth() + 1) + "/" + (dt.getYear() + 1900);
        
         for(int i = 0; i < hotel.getAllAccomodations().size(); i++) {
            for(int j = 0; j < hotel.getAllAccomodations().get(i).getBookedDays().size(); j++){
               if(hotel.getAllAccomodations().get(i).getBookedDays().get(j).toString().equals(date)) {
                  for(int k = 0; k < hotel.getAllAccomodations().get(i).getBookedGuests().size(); k++){
                     searchBookingsModel.addElement(hotel.getAllAccomodations().get(i).getBookedGuests().get(k));
                  }
               }
            }
         }
         //Search for bookings by fullname **********************************
         } else if(!(SearchBookingNameText.getText().equals("")) && (!(SearchBookingSurnameText.getText().equals("")))){
         searchBookingsModel.clear();
         String name = SearchBookingNameText.getText();
         String surname = SearchBookingSurnameText.getText();
         
         for(int i = 0; i < hotel.getAllAccomodations().size(); i++) {
            for(int j = 0; j < hotel.getAllAccomodations().get(i).getBookedGuests().size(); j++){
               if(hotel.getAllAccomodations().get(i).getBookedGuests().get(j).getSurname().equals(surname) && hotel.getAllAccomodations().get(i).getBookedGuests().get(j).getName().equals(name)) {
                  for(int k = 0; k < hotel.getAllAccomodations().get(i).getBookedGuests().size(); k++){
                     searchBookingsModel.addElement(hotel.getAllAccomodations().get(i).getBookedGuests().get(k));
                  }
               }
            }
         } 
         //Search for bookings by name***************************************
         } else if((!(SearchBookingNameText.getText().equals(""))) && ((SearchBookingSurnameText.getText().equals("")) || (SearchBookingSurnameText.getText().equals("Enter surname"))))  {
          searchBookingsModel.clear();
          String name = SearchBookingNameText.getText();
          for(int i = 0; i < hotel.getAllAccomodations().size(); i++) {
                 for(int j = 0; j < hotel.getAllAccomodations().get(i).getBookedGuests().size(); j++){
                    if(hotel.getAllAccomodations().get(i).getBookedGuests().get(j).getSurname().equals(name)) {
                       for(int k = 0; k < hotel.getAllAccomodations().get(i).getBookedGuests().size(); k++){
                          searchBookingsModel.addElement(hotel.getAllAccomodations().get(i).getBookedGuests().get(k));
                       }
                    }
                 }
         }
        //Search for bookings by surname*************************************
         } else if((!(SearchBookingSurnameText.getText().equals(""))) && ((SearchBookingNameText.getText().equals("")) || (SearchBookingNameText.getText().equals("Enter name"))))  {
          searchBookingsModel.clear();
          String surname = SearchBookingSurnameText.getText();
          for(int i = 0; i < hotel.getAllAccomodations().size(); i++) {
                 for(int j = 0; j < hotel.getAllAccomodations().get(i).getBookedGuests().size(); j++){
                    if(hotel.getAllAccomodations().get(i).getBookedGuests().get(j).getSurname().equals(surname)) {
                       for(int k = 0; k < hotel.getAllAccomodations().get(i).getBookedGuests().size(); k++){
                          searchBookingsModel.addElement(hotel.getAllAccomodations().get(i).getBookedGuests().get(k));
                       }
                    }
                 }
         }
         //Search for bookings by room number********************************
      } else {
         searchBookingsModel.clear();
         int roomNo =(int) SearchBookingRoomNo.getValue();
         
         for(int i = 0; i < hotel.getAllAccomodations().size(); i++) {
               if(hotel.getAllAccomodations().get(i).getRoomNumber() == roomNo) {
                  for(int k = 0; k < hotel.getAllAccomodations().get(i).getBookedGuests().size(); k++){
                     searchBookingsModel.addElement(hotel.getAllAccomodations().get(i).getBookedGuests().get(k));
                  }
               }
         }
      }
      }
   }

   class ArrDepRefresh implements ActionListener {
      @SuppressWarnings("deprecation")
      public void actionPerformed(ActionEvent e)
      {
         Date td = new Date();
         Date dp = new Date();
         Date ar = new Date();
         String today = td.getDate() + "/" + (td.getMonth() + 1)  + "/" + (td.getYear() + 1900);
         int hours = td.getHours();
         ArrayList <String> temp = new ArrayList<>();
         //Arrivals ************************************
         arrivalsModel.clear();
         for(int i = 0; i < hotel.getAllAccomodations().size(); i++){
            for(int j = 0; j < hotel.getAllAccomodations().get(i).getBookedGuests().size(); j++){
               if(hotel.getAllAccomodations().get(i).getBookedGuests().get(j).getArrival().equals(today)){
                  int num = hotel.getAllAccomodations().get(i).getRoomNumber();
                  String name = hotel.getAllAccomodations().get(i).getBookedGuests().get(j).getName();
                  String surname = hotel.getAllAccomodations().get(i).getBookedGuests().get(j).getSurname();
                  if(hours >= 18){
                     temp.add("Room: " + num + ", Name: " + name + " " + surname + " | GUEST IS LATE");
                  }else{
                     temp.add("Room: " + num + ", Name: " + name + " " + surname);  
                  }
               }
            }
         }
         for(int k = 0; k < temp.size(); k++){
            arrivalsModel.addElement(temp.get(k));
         }
         //Departures*********************************
         departuresModel.clear();
         for(int i = 0; i < hotel.getAllCheckedAccomodations().size(); i++){
            for(int j = 0; j < hotel.getAllCheckedAccomodations().get(i).getCheckedGuests().size(); j++){
               if(hotel.getAllCheckedAccomodations().get(i).getCheckedGuests().get(j).getDeparture().equals(today)){
                  int num = hotel.getAllCheckedAccomodations().get(i).getRoomNumber();
                  String name = hotel.getAllCheckedAccomodations().get(i).getCheckedGuests().get(j).getName();
                  String surname = hotel.getAllCheckedAccomodations().get(i).getCheckedGuests().get(j).getSurname();
                  departuresModel.addElement("Room: " + num + ", Name: " + name + " " + surname);
               }
            }
         }
      }
      
   }
   // NOT SO COMPLICATED AL ***********************************************
   class RefreshCheckOut implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e)
      {
         actualCheckedRooms.clear();
         for(int i =0; i<hotel.getAllCheckedAccomodations().size(); i++){
            actualCheckedRooms.addElement(hotel.getAllCheckedAccomodations().get(i));
         }
         
      }
      
   }
   
   class CancelBooking implements ActionListener{
      @Override
      public void actionPerformed(ActionEvent e)
      {
        cancelBooking();
      }
      
   }
   
   class SearchGuestsClear implements ActionListener{ 
         @Override
         public void actionPerformed(ActionEvent e)
         {
           searchGuestsModel.clear();
           SearchGuestsNameText.setText("");
           SearchGuestsSurnameText.setText("");
           roomsModel2.setValue(0);
         }
   }
   
   class SearchGuests implements ActionListener{ 
      @Override
      public void actionPerformed(ActionEvent e){
         String name = SearchGuestsNameText.getText();
         String surname = SearchGuestsSurnameText.getText();
         int room = (int) SearchGuestsRoomsSpinner.getValue();
         searchGuestsModel.clear();
         //SEARCH BY NAME SURNAME AND ROOM
         if((!(name.equals(""))) && (!(surname.equals("")) && room != 0 )){
             for(int i = 0; i < hotel.getAllAccomodations().size(); i++) {
                for(int j = 0; j < hotel.getAllAccomodations().get(i).getCheckedGuests().size(); j++){
                   if(hotel.getAllAccomodations().get(i).getCheckedGuests().get(j).getSurname().equals(surname) && hotel.getAllAccomodations().get(i).getCheckedGuests().get(j).getName().equals(name) && room == hotel.getAllAccomodations().get(i).getRoomNumber()){
                      searchGuestsModel.addElement(hotel.getAllAccomodations().get(i).getCheckedGuests().get(j));
                   }
                }
             }  
         }//SEARCH BY NAME AND SURNAME 
         else if((!(name.equals(""))) && (!(surname.equals("")) && room == 0 )) {
          for(int i = 0; i < hotel.getAllAccomodations().size(); i++) {
                 for(int j = 0; j < hotel.getAllAccomodations().get(i).getCheckedGuests().size(); j++){
                    if(hotel.getAllAccomodations().get(i).getCheckedGuests().get(j).getSurname().equals(surname) && hotel.getAllAccomodations().get(i).getCheckedGuests().get(j).getName().equals(name) ){
                       searchGuestsModel.addElement(hotel.getAllAccomodations().get(i).getCheckedGuests().get(j));
                    }
                 }
              }  
         }
         // SEARCH BY SURNAME
         else if((name.equals("")) && (!(surname.equals("")) && room == 0 )) {
            for(int i = 0; i < hotel.getAllAccomodations().size(); i++) {
              for(int j = 0; j < hotel.getAllAccomodations().get(i).getCheckedGuests().size(); j++){
                 if(hotel.getAllAccomodations().get(i).getCheckedGuests().get(j).getSurname().equals(surname)) {
                       searchGuestsModel.addElement(hotel.getAllAccomodations().get(i).getCheckedGuests().get(j));
                 }
              }
            }
         }//SEARCH BY NAME
         else if ((!(name.equals(""))) && ((surname.equals("")) && room == 0 )) {
           for(int i = 0; i < hotel.getAllAccomodations().size(); i++) {
              for(int j = 0; j < hotel.getAllAccomodations().get(i).getCheckedGuests().size(); j++){
                 if(hotel.getAllAccomodations().get(i).getCheckedGuests().get(j).getName().equals(name)) {
                       searchGuestsModel.addElement(hotel.getAllAccomodations().get(i).getCheckedGuests().get(j));
                 }
              }
           }
         } 
         else if (((name.equals(""))) && ((surname.equals("")) && room != 0 )) {
            for(int i = 0; i < hotel.getAllAccomodations().size(); i++) {
              for(int j = 0; j < hotel.getAllAccomodations().get(i).getCheckedGuests().size(); j++){
                 if(room == hotel.getAllAccomodations().get(i).getRoomNumber()) {
                       searchGuestsModel.addElement(hotel.getAllAccomodations().get(i).getCheckedGuests().get(j));
                 }
              }
            }
         } 
      }
   }
   
   class ResetBK implements ActionListener{
      public void actionPerformed(ActionEvent e)
      {
         resetBK();
      }
   }
   
   class searchPastGuests implements ActionListener{
      public void actionPerformed(ActionEvent e)
      {
         searchPastGuestsModel.clear();
         for(int i = 0; i < hotel.getAllPastGuests().size(); i++){
            if(SearchPastGuestsNameText.getText().equals(hotel.getAllPastGuests().get(i).getName()) 
                  && SearchPastGuestsSurnameText.getText().equals(hotel.getAllPastGuests().get(i).getSurname())){
               String temp = "Guest name: " + hotel.getAllPastGuests().get(i).getName() + " " + hotel.getAllPastGuests().get(i).getSurname() + ", birthday: " + hotel.getAllPastGuests().get(i).getBirthday() + ", phone number: " + hotel.getAllPastGuests().get(i).getPhoneNumber();
               searchPastGuestsModel.addElement(temp);
            }
         }
      }
   }
   
   class ResetCI implements ActionListener{
      public void actionPerformed(ActionEvent e)
      {
         resetCI();
      }
   }
   
   class CheckOut implements ActionListener{
      @Override
      public void actionPerformed(ActionEvent e)
      {
         Accomodation selectedElement = (Accomodation) CheckOutList.getSelectedValue();
         double totalPrice = (selectedElement.getPrice() * (Integer)(TotalDaysSpinner.getValue())) + selectedElement.getPriceForExtraBed() - (selectedElement.getDiscount() * (Integer)(TotalDaysSpinner.getValue()));
                  
         if(MiniBar.isSelected()){
            totalPrice += Double.parseDouble(MiniBarPrice.getText());
         }
         if(Laundry.isSelected()){
            double laundryPrice = 10;
            double totalLaundryPrice = laundryPrice * (Integer)(LaundrySpinner.getValue());
            totalPrice += totalLaundryPrice;
         }
         if(RoomService.isSelected()){
            double roomServicePrice = 10;
            double totalRoomServicePrice = roomServicePrice * (Integer)(RoomServiceSpinner.getValue());
            totalPrice += totalRoomServicePrice;
         }
         JOptionPane.showMessageDialog(CheckOut,"Total price is: "+ totalPrice);
         MiniBarPrice.setText("Enter price");
         LaundrySpinner.setValue(0);
         RoomServiceSpinner.setValue(0);
         TotalDaysSpinner.setValue(0);
         actualCheckedRooms.clear();
         
         for(int i =0; i<hotel.getAllCheckedAccomodations().size(); i++){
            actualCheckedRooms.addElement(hotel.getAllCheckedAccomodations().get(i));
         }
         removeCheckInDays(selectedElement.getActualGuests().get(0).getArrival(), selectedElement.getActualGuests().get(0).getDeparture(),
               selectedElement.getRoomNumber());
         try{
            hotel.functions().inputDataToFiles(hotel);
         }catch (Exception e1){
            e1.printStackTrace();
         }
         
         for(int i =0;i< hotel.getAllAccomodations().size(); i++){
            if(selectedElement.equals(hotel.getAllAccomodations().get(i))){
               hotel.getAllAccomodations().get(i).checkOut();  
            }
         }
         try{
            hotel.functions().inputDataToFiles(hotel);
         }catch (Exception e1){
            e1.printStackTrace();
         }
         updateFreeRooms();
      } 
   }
   
   class checkInFromBooking implements ActionListener{
      @Override
      public void actionPerformed(ActionEvent e)
      {
         String arrival = "";
         String departure = "";
         String birthday = "";
         BookingGuest selectedElement = (BookingGuest) SearchBookingsJList.getSelectedValue();
         NameCI.setText(selectedElement.getName());
         SurnameCI.setText(selectedElement.getSurname());
         AddressCI.setText(selectedElement.getAddress());
         PhoneNoCI.setText(Long.toString(selectedElement.getPhoneNumber()));
         RoomCI.setText(Integer.toString(selectedElement.getRoomNo()));
         DiscountCI.setText(Double.toString(selectedElement.getDiscount()));
         arrival = selectedElement.getArrival();
         departure = selectedElement.getDeparture();
         birthday = selectedElement.getBirthday();
         
         String arrivalsValues[] = arrival.split("/");
         int d = Integer.parseInt(arrivalsValues[0]);
         int m = Integer.parseInt(arrivalsValues[1]);
         int y = Integer.parseInt(arrivalsValues[2]);
         m--;
         y = y - 1900;
         
         String departuresValues[] = departure.split("/");
         int d1 = Integer.parseInt(departuresValues[0]);
         int m1 = Integer.parseInt(departuresValues[1]);
         int y1 = Integer.parseInt(departuresValues[2]);
         m1--;
         y1 = y1 - 1900;
         
         String birthdayValues[] = birthday.split("/");
         int d2 = Integer.parseInt(birthdayValues[0]);
         int m2 = Integer.parseInt(birthdayValues[1]);
         int y2 = Integer.parseInt(birthdayValues[2]);
         m2--;
         y2 = y2 - 1900;
         
         Date ar = new Date(y, m, d);
         Date dp = new Date(y1, m1, d1);
         Date bd = new Date(y2, m2, d2);
         
         ArrivalCI.setDate(ar);
         DepartureCI.setDate(dp);
         BirthdayCI.setDate(bd);
         
         cancelBooking();
         try{
            hotel.functions().inputDataToFiles(hotel);
         }catch (Exception e1){
            e1.printStackTrace();
         }
         TopPanel.setSelectedIndex(1);
      }
   }
      
   class modifyBooking implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
            String arrival = "";
            String departure = "";
            String birthday = "";
            BookingGuest selectedElement = (BookingGuest) SearchBookingsJList.getSelectedValue();
            NameBK.setText(selectedElement.getName());
            SurnameBK.setText(selectedElement.getSurname());
            AddressBK.setText(selectedElement.getAddress());
            NationalityBK.setText(selectedElement.getNationality());
            PhoneNoBK.setText(Long.toString(selectedElement.getPhoneNumber()));
            RoomBK.setText(Integer.toString(selectedElement.getRoomNo()));
            DiscountBK.setText(Double.toString(selectedElement.getDiscount()));
           
            arrival = selectedElement.getArrival();
            departure = selectedElement.getDeparture();
            birthday = selectedElement.getBirthday();
            
            String arrivalsValues[] = arrival.split("/");
            int d = Integer.parseInt(arrivalsValues[0]);
            int m = Integer.parseInt(arrivalsValues[1]);
            int y = Integer.parseInt(arrivalsValues[2]);
            m--;
            y = y - 1900;
            
            String departuresValues[] = departure.split("/");
            int d1 = Integer.parseInt(departuresValues[0]);
            int m1 = Integer.parseInt(departuresValues[1]);
            int y1 = Integer.parseInt(departuresValues[2]);
            m1--;
            y1 = y1 - 1900;
            
            String birthdayValues[] = birthday.split("/");
            int d2 = Integer.parseInt(birthdayValues[0]);
            int m2 = Integer.parseInt(birthdayValues[1]);
            int y2 = Integer.parseInt(birthdayValues[2]);
            m2--;
            y2 = y2 - 1900;
            
            Date ar = new Date(y, m, d);
            Date dp = new Date(y1, m1, d1);
            Date bd = new Date(y2, m2, d2);
            
            ArrivalBK.setDate(ar);
            DepartureBK.setDate(dp);
            BirthdayBK.setDate(bd);
            
            cancelBooking();
            try{
               hotel.functions().inputDataToFiles(hotel);
            }catch (Exception e1){
               e1.printStackTrace();
            }
            TopPanel.setSelectedIndex(0);
         }
         
      }
   
   class refreshPastGuests implements ActionListener{

      @Override
      public void actionPerformed(ActionEvent e)
      {
         getAllPastGuests();
      }
      
   }
   // OTHER METHODS *******************************************************
   public boolean equals(ArrayList<String> booked, ArrayList<String> temp){
      for(int i = 0; i < temp.size(); i++){
         for(int z = 0; z < booked.size(); z++){
            if(!(temp.get(i).equals(booked.get(z)))){
               
            }
            else{
               return false;
            }
         }      
      }
      return true;
   }
   
   public void resetBK(){
      NameBK.setText("");
      SurnameBK.setText("");
      AddressBK.setText("");
      NationalityBK.setText("");
      PhoneNoBK.setText("");
      RoomBK.setText("");
      BirthdayBK.setDate(null);
      ArrivalBK.setDate(null);
      DepartureBK.setDate(null);
      ExtraBedBK.setSelected(false);
      DiscountBK.setText("");
   }
   
   public void resetCI(){
      NameCI.setText("");
      SurnameCI.setText("");
      AddressCI.setText("");
      PhoneNoCI.setText("");
      RoomCI.setText("");
      PassportCI.setText("");
      EmailCI.setText("");
      BirthdayCI.setDate(null);
      ArrivalCI.setDate(null);
      DepartureCI.setDate(null);
      ExtraBedCI.setSelected(false);
      DiscountCI.setText("");
   }
   
   public void getAllPastGuests(){
      searchPastGuestsModel.clear();
      for(int i = 0; i < hotel.getAllPastGuests().size(); i++){
         String temp = "Guest name: " + hotel.getAllPastGuests().get(i).getName() + " " + hotel.getAllPastGuests().get(i).getSurname() + ", birthday: " + hotel.getAllPastGuests().get(i).getBirthday() + ", phone number: " + hotel.getAllPastGuests().get(i).getPhoneNumber();
         searchPastGuestsModel.addElement(temp);
      }
   }

   public void updateFreeRooms() {
      actualFreeRoomsModel.clear();
      getFreeRooms();
   }
   
   public void getFreeRooms(){
      for(int i = 0; i < hotel.getAllAvailableAccomodations().size(); i++){
         actualFreeRoomsModel.addElement(hotel.getAllAvailableAccomodations().get(i));
      }
   }
   
   public void fillCheckerBooking(){
      if(NameBK.getText().equals("")){
         JOptionPane.showMessageDialog(TabContentBK, "Please enter name!");
      }
      else if(SurnameBK.getText().equals("")){
         JOptionPane.showMessageDialog(TabContentBK, "Please enter surname!");
      }
      else if(NationalityBK.getText().equals("")){
         JOptionPane.showMessageDialog(TabContentBK, "Please enter nationality!");
      }
      else if(AddressBK.getText().equals("")){
         JOptionPane.showMessageDialog(TabContentBK, "Please enter address!");
      }
      else if(PhoneNoBK.getText().equals("")){
         JOptionPane.showMessageDialog(TabContentBK, "Please enter phone number!");
      }
      else if(RoomBK.getText().equals("")){
         JOptionPane.showMessageDialog(TabContentBK, "Please enter room number!");
      }
      else if(BirthdayBK.getDate() == null){
         JOptionPane.showMessageDialog(TabContentBK, "Please enter birthday!");
      }
      else if(ArrivalBK.getDate() == null){
         JOptionPane.showMessageDialog(TabContentBK, "Please enter arrival date!");
      }
      else if(DepartureBK.getDate() == null){
         JOptionPane.showMessageDialog(TabContentBK, "Please enter departure date!");
      }
      else if(DiscountBK.getText().equals("")){
         DiscountBK.setText("0"); 
      }
   }
   
   public void fillCheckerCheckIn(){
      if(NameCI.getText().equals("")){
         JOptionPane.showMessageDialog(TabContentCI, "Please enter name!");
      }
      else if(SurnameCI.getText().equals("")){
         JOptionPane.showMessageDialog(TabContentCI, "Please enter surname!");
      }
      else if(AddressCI.getText().equals("")){
         JOptionPane.showMessageDialog(TabContentCI, "Please enter address!");
      }
      else if(PhoneNoCI.getText().equals("")){
         JOptionPane.showMessageDialog(TabContentCI, "Please enter phone number!");
      }
      else if(RoomCI.getText().equals("")){
         JOptionPane.showMessageDialog(TabContentCI, "Please enter room number!");
      }
      else if(PassportCI.getText().equals("")){
         JOptionPane.showMessageDialog(TabContentCI, "Please enter passport number!");
      }
      else if(EmailCI.getText().equals("")){
         JOptionPane.showMessageDialog(TabContentCI, "Please enter e-mail!");
      }
      else if(BirthdayCI.getDate() == null){
         JOptionPane.showMessageDialog(TabContentCI, "Please enter birthday!");
      }
      else if(ArrivalCI.getDate() == null){
         JOptionPane.showMessageDialog(TabContentCI, "Please enter arrival date!");
      }
      else if(DepartureCI.getDate() == null){
         JOptionPane.showMessageDialog(TabContentCI, "Please enter departure date!");
      }
      else if(DiscountCI.getText().equals("")){
         DiscountCI.setText("0"); 
      }
   }
    
   public void cancelBooking() {
      String departure = "";
    String arrival = "";
    int roomNo = 0;
       BookingGuest selectedElement = (BookingGuest) SearchBookingsJList.getSelectedValue();
       for(int i = 0; i < hotel.getAllAccomodations().size(); i++){
          for(int j = 0; j < hotel.getAllAccomodations().get(i).getBookedGuests().size(); j++){
             if(selectedElement.equals(hotel.getAllAccomodations().get(i).getBookedGuests().get(j))){
                hotel.getAllAccomodations().get(i).removeBookingGuest(j);
                arrival = selectedElement.getArrival();
                departure = selectedElement.getDeparture();
                roomNo = selectedElement.getRoomNo();
                break;
             }
          }
       }
       
       
       String arrivalsValues[] = arrival.split("/");
       int d = Integer.parseInt(arrivalsValues[0]);
       int m = Integer.parseInt(arrivalsValues[1]);
       int y = Integer.parseInt(arrivalsValues[2]);
       m--;
       y = y - 1900;
       
       String departuresValues[] = departure.split("/");
       int d1 = Integer.parseInt(departuresValues[0]);
       int m1 = Integer.parseInt(departuresValues[1]);
       int y1 = Integer.parseInt(departuresValues[2]);
       m1--;
       y1 = y1 - 1900;
       
       Date ar = new Date(y, m, d);
       Date dp = new Date(y1, m1, d1);
       
       hotel.functions().countDatesFromInput(dp, ar);
          for(int i = 0; i < hotel.getAllAccomodations().get(roomNo-1).getBookedDays().size(); i++) {
             for(int j = 0; j < hotel.functions().getTempArrayList().size(); j++){
             if(hotel.functions().getTempArrayList().get(j).equals(hotel.getAllAccomodations().
                   get(roomNo-1).getBookedDays().get(i))) {
                hotel.getAllAccomodations().get(roomNo-1).getBookedDays().remove(i);
             }
             }
          }
   }
   public void removeCheckInDays(String arrival, String departure, int roomNo) {
         
         
         String arrivalsValues[] = arrival.split("/");
         int d = Integer.parseInt(arrivalsValues[0]);
         int m = Integer.parseInt(arrivalsValues[1]);
         int y = Integer.parseInt(arrivalsValues[2]);
         m--;
         y = y - 1900;
         
         String departuresValues[] = departure.split("/");
         int d1 = Integer.parseInt(departuresValues[0]);
         int m1 = Integer.parseInt(departuresValues[1]);
         int y1 = Integer.parseInt(departuresValues[2]);
         m1--;
         y1 = y1 - 1900;
         
         Date ar = new Date(y, m, d);
         Date dp = new Date(y1, m1, d1);
         
         hotel.functions().countDatesFromInput(dp, ar);
            for(int i = 0; i < hotel.getAllAccomodations().get(roomNo-1).getCheckedDays().size(); i++) {
               for(int j = 0; j < hotel.functions().getTempArrayList().size(); j++){
               if(hotel.functions().getTempArrayList().get(j).equals(hotel.getAllAccomodations().
                     get(roomNo-1).getCheckedDays().get(i))) {
                  hotel.getAllAccomodations().get(roomNo-1).getCheckedDays().remove(i);
               }
               }
            }
   }
   
   public static void main(String[] args) throws Exception {
      Hotel hotel = new Hotel("The Deer Alley Hotel", "The Deer Alley 1");
      Test gui = new Test(hotel);   
      gui.setExtendedState(JFrame.MAXIMIZED_BOTH);
      gui.setVisible(true);
   }
}