package as2resit;

import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

class Member{
    private String membershipNumber;
    private String name;
    private String bankDetails;

    public Member(String membershipNumber, String name, String bankDetails){
        this.membershipNumber = membershipNumber;
        this.name = name;
        this.bankDetails = bankDetails;
    }

    public String getMembershipNumber(String membershipNumber){
        return this.membershipNumber;
    }

    public void setMembershipNumber(String membershipNumber){
        this.membershipNumber = membershipNumber;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getBankDetails(){
        return bankDetails;
    }

    public void setBankDetails(String bankDetails){
        this.bankDetails = bankDetails;
    }
}


public class LeisureFacility {
    private double swimmingPoolFee;
    private double sportsHallFee;
    private double exerciseStudioFee;
    private double weightsStudioFee;

    private double schoolPriorityDiscount;

    private double swimmingPoolCost;
    private double staffingCost;

    private Map<String, Member> memberDatabase;
    private Map<String, Member> filingCabinet;

    public LeisureFacility() {

    }

    public LeisureFacility(double swimmingPoolFee, double sportsHallFee, double weightsStudioFee, double schoolPriorityDiscount, double swimmingPoolCost, double staffingCost, double exerciseStudioFee) {
        Map<String, Member> memberDatabase = new HashMap<>();

        this.swimmingPoolFee = swimmingPoolFee;

        this.sportsHallFee = sportsHallFee;
        this.exerciseStudioFee = exerciseStudioFee;
        this.weightsStudioFee = weightsStudioFee;
        this.schoolPriorityDiscount = schoolPriorityDiscount;
        this.swimmingPoolCost = swimmingPoolCost;
        this.staffingCost = staffingCost;

        this.memberDatabase = new HashMap<>();
        this.filingCabinet = new HashMap<>();

    }

    public void addMember(String membershipNumber, Member member) {
        memberDatabase.put(membershipNumber, member);
        filingCabinet.put(member.getName(), member);
    }

    public Member getMember(String membershipNumber) {

        return memberDatabase.get(membershipNumber);
    }

    public Member findMemberByName(String name) {
        return filingCabinet.get(name);
    }

    public double calculateTotalIncome(int schoolPriorityUsage, int mangoesMember, int publicUsage, double facilityRentalIncome, double membershipIncome) {
        double schoolIncome = (swimmingPoolFee + sportsHallFee + exerciseStudioFee + weightsStudioFee) * schoolPriorityUsage * (1 - schoolPriorityDiscount);
        double mangoesMembersIncome = (swimmingPoolFee + sportsHallFee + exerciseStudioFee + weightsStudioFee) * mangoesMember;
        double publicIncome = (swimmingPoolFee + sportsHallFee + exerciseStudioFee + weightsStudioFee) * publicUsage;
        double totalIncome = schoolIncome + mangoesMembersIncome + publicIncome + facilityRentalIncome + membershipIncome;
        return totalIncome;
    }

    public double calculateNetIncome(int schoolPriorityUsage, int mangoesMember, int publicUsage, double facilityRentalIncome, double membershipIncome) {
        double totalIncome = calculateTotalIncome(schoolPriorityUsage, mangoesMember, publicUsage, facilityRentalIncome, membershipIncome);
        double netIncome = totalIncome - swimmingPoolCost - staffingCost;
        return netIncome;
    }

    public  static  void main(String [] args){
        double swimmingPoolFee = 10.0;
        double sportsHallFee = 15.0;
        double exerciseStudioFee = 20.0;
        double weightsStudioFee = 25.0;

        double schoolPriorityDiscount = 0.2;

        double swimmingPoolCost = 5000.0;
        double staffingCost = 3000.0;

        LeisureFacility facility = new LeisureFacility(swimmingPoolFee,sportsHallFee,exerciseStudioFee,weightsStudioFee,schoolPriorityDiscount,swimmingPoolCost,staffingCost);
        SwingUtilities.invokeLater(()-> new LeisureFacility());
        // create a sample number
        LesiureFacilityGui frame = new LesiureFacilityGui(facility);

        String membershipNumber = frame.getMembershipNumber();
        System.out.println("main function membership number "+ membershipNumber);
        String name = frame.getName();
        String bankDetails = frame.getBankDetails();


//        String membershipNumber = "M123";
//        String name = "John Smith";
//        String bankDetails = "123456789";
        Member member = new Member(membershipNumber,name, bankDetails);

        facility.addMember(membershipNumber,member);
        Member retrievedMember = facility.getMember(membershipNumber);
        System.out.println("Retrieved Member: ");
        System.out.println("Membership Number: " + retrievedMember.getMembershipNumber(membershipNumber));
        System.out.println("Name: " + retrievedMember.getName());
        System.out.println("Bank Details : " + retrievedMember.getBankDetails());

        Member foundMember = facility.findMemberByName(name);
        System.out.println("Found Member: ");
        System.out.println("Membership Number: " + foundMember.getMembershipNumber(membershipNumber));
        System.out.println("Name: " + foundMember.getName());
        System.out.println("Bank Details: " + foundMember.getBankDetails());

    }
}


class LesiureFacilityGui{
    public String membershipNumber = "M1245";
    public String name = "Rup";
    public String bankDetails="123456789";
    public LesiureFacilityGui(LeisureFacility facility){

        JFrame frame = new JFrame();

        frame.setSize(720,470);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel membershipNumberLabel = new JLabel("Enter your member ship number:");
        membershipNumberLabel.setBounds(20,20,200,20);
        frame.add(membershipNumberLabel);

        JTextField membershipNumberTextField = new JTextField();
        membershipNumberTextField.setBounds(220,20,200,20);
        frame.add(membershipNumberTextField);


        JLabel nameLabel = new JLabel("Enter your name:");
        nameLabel.setBounds(20,40,200,20);
        frame.add(nameLabel);

        JTextField nameTextField = new JTextField();
        nameTextField.setBounds(220,40,200,20);
        frame.add(nameTextField);

        JLabel bankDetailsLabel = new JLabel("Enter your Bank Details:");
        bankDetailsLabel.setBounds(20,60,200,20);
        frame.add(bankDetailsLabel);

        JTextField bankDetailsTextField = new JTextField();
        bankDetailsTextField.setBounds(220,60,200,20);
        frame.add(bankDetailsTextField);


        JButton byMembershipNumber = new JButton("search by Membership Number");
        byMembershipNumber.setBounds(50,100,200,20);
        frame.add(byMembershipNumber);

//        JButton findByName = new JButton("search by Name");
//        findByName.setBounds(240,100,200,20);
//        frame.add(findByName);


        JLabel membershipnumberLabel1 = new JLabel();
        membershipnumberLabel1.setBounds(30,120,200,20);
        frame.add(membershipnumberLabel1);

        JLabel nameLabel1 = new JLabel();
        nameLabel1.setBounds(30,140,200,20);
        frame.add(nameLabel1);

        JLabel bankDetailsLabel1 = new JLabel();
        bankDetailsLabel1.setBounds(30,160,200,20);
        frame.add(bankDetailsLabel1);
//
//        findByName.addActionListener(e->{
//            this.membershipNumber = membershipNumberTextField.getText();
//            this.name = nameTextField.getText();
//            this.bankDetails = bankDetailsTextField.getText();
//            Member foundMember = faculty.findMemberByName(name);
//            membershipnumberLabel1.setText(String.valueOf(foundMember.getMembershipNumber(membershipNumber)));
//            nameLabel1.setText(String.valueOf(foundMember.getName()));
//            bankDetailsLabel1.setText(String.valueOf(foundMember.getBankDetails()));
//            JOptionPane.showMessageDialog(frame,"Registration successful");
//
//        });

        byMembershipNumber.addActionListener(e->{
            this.membershipNumber = membershipNumberTextField.getText();
            this.name = nameTextField.getText();
            this.bankDetails = bankDetailsTextField.getText();
            Member member = new Member(membershipNumber,name, bankDetails);
            facility.addMember(membershipNumber,member);
            Member retrievedMember = facility.getMember(membershipNumber);
            membershipnumberLabel1.setText(retrievedMember.getMembershipNumber(membershipNumber));
            nameLabel1.setText(retrievedMember.getName());
            bankDetailsLabel1.setText(retrievedMember.getBankDetails());
            JOptionPane.showMessageDialog(frame,"Registration successful");

        });

        frame.setVisible(true);
    }
    public String getMembershipNumber(){
//        System.out.println("gui with this membership number "+ this.membershipNumber);

        return membershipNumber;
    }
    public String getName(){
        return name;
    }
    public String getBankDetails(){
        return bankDetails;
    }
}
