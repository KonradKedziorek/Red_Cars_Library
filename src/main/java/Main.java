import Controllers.*;
import Models.*;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.dialogs.MessageDialog;
import com.googlecode.lanterna.gui2.dialogs.MessageDialogButton;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;

public class Main {
    public static void main(String[] args) throws IOException {

        CarController carController = new CarController();
        PersonController personController = new PersonController();
        RentController rentController = new RentController();
        ClientController clientController = new ClientController();
        EmployeeController employeeController = new EmployeeController();
        WageController wageController = new WageController();
        ReservationController reservationController = new ReservationController();
        InsuranceController insuranceController = new InsuranceController();
        VehicleInspectionController vehicleInspectionController = new VehicleInspectionController();
        FaultController faultController = new FaultController();

        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        Screen screen = null;

        try {
            screen = terminalFactory.createScreen();
            screen.startScreen();

            final WindowBasedTextGUI textGUI = new MultiWindowTextGUI(screen);

            final Window window = new BasicWindow();
            final Window searchCarByIdWindow = new BasicWindow("Search car by Id");
            final Window searchCarByModelWindow = new BasicWindow("Search car by model");
            final Window searchCarByVINWindow = new BasicWindow("Search car by VIN");
            final Window searchCarByBrandWindow = new BasicWindow("Search car by brand");
            final Window printAllCarsWindow = new BasicWindow("All cars");
            final Window addCarWindow = new BasicWindow("Add car");
            final Window removeCarWindow = new BasicWindow("Remove car");
            final Window removeCarCheckWindow = new BasicWindow("Remove car");
            final Window searchPersonWindow = new BasicWindow("Search person");
            final Window addPersonWindow = new BasicWindow("Add person");
            final Window removePersonWindow = new BasicWindow("Remove person");
            final Window removePersonCheckWindow = new BasicWindow("Remove person");
            final Window searchRentByIdWindow = new BasicWindow("Search rent");
            final Window addRentWindow = new BasicWindow("Add rent");
            final Window removeRentWindow = new BasicWindow("Remove rent");
            final Window removeRentCheckWindow = new BasicWindow("Return Car");
            final Window addClientWindow = new BasicWindow("Add client");
            final Window removeClientWindow = new BasicWindow("Remove client");
            final Window removeClientCheckWindow = new BasicWindow("Remove client");
            final Window searchCarToRemoveWindow = new BasicWindow("Remove car");
            final Window searchRentToRemoveWindow = new BasicWindow("Return car");
            final Window editCarWindow = new BasicWindow("Edit car");
            final Window editSearchedCarWindow = new BasicWindow("Edit car");
            final Window editPersonWindow = new BasicWindow("Edit person");
            final Window editSearchedPersonWindow = new BasicWindow("Edit person");
            final Window searchEmployeeByIdWindow = new BasicWindow("Search employee");
            final Window addEmployeeWindow = new BasicWindow("Add employee");
            final Window editEmployeeWindow = new BasicWindow("Edit employee");
            final Window editSearchedEmployeeWindow = new BasicWindow("Edit employee");
            final Window removeEmployeeWindow = new BasicWindow("Remove employee");
            final Window removeEmployeeCheckWindow = new BasicWindow("Remove employee");
            final Window addReservationWindow = new BasicWindow("Add reservation");
            final Window removeReservationWindow = new BasicWindow("Remove reservation");
            final Window removeReservationCheckWindow = new BasicWindow("Return reservation");
            final Window searchReservationToRemoveWindow = new BasicWindow("Return reservation");
            final Window addInsuranceWindow = new BasicWindow("Add insurance");
            final Window removeInsuranceWindow = new BasicWindow("Remove insurance");
            final Window removeInsuranceCheckWindow = new BasicWindow("Remove insurance");
            final Window addWageWindow = new BasicWindow("Add wage");
            final Window editWageWindow = new BasicWindow("Edit wage");
            final Window editSearchedWageWindow = new BasicWindow("Edit wage");
            final Window removeWageWindow = new BasicWindow("Remove wage");
            final Window removeWageCheckWindow = new BasicWindow("Remove wage");
            final Window addVehicleInspectionWindow = new BasicWindow("Add vehicle inspection");
            final Window removeVehicleInspectionWindow = new BasicWindow("Remove vehicle inspection");
            final Window removeVehicleInspectionCheckWindow = new BasicWindow("Remove vehicle inspection");
            final Window addFaultWindow = new BasicWindow("Add fault");
            final Window editFaultWindow = new BasicWindow("Edit fault");
            final Window editSearchedFaultWindow = new BasicWindow("Edit fault");
            final Window removeFaultWindow = new BasicWindow("Remove fault");
            final Window removeFaultCheckWindow = new BasicWindow("Remove fault");
            final Window checkReservationWindow = new BasicWindow("Add rent");
            final Window checkReservationByPeselWindow = new BasicWindow("Add rent");
            final Window chooseReservationToExecuteWindow = new BasicWindow("Add rent");
            final Window changeReservationToRentWindow = new BasicWindow("Add rent");

            Panel contentPanel = new Panel(new GridLayout(2));
            Panel searchCarByIdPanel = new Panel();
            Panel searchCarByModelPanel = new Panel();
            Panel searchCarByVINPanel = new Panel();
            Panel searchCarByBrandPanel = new Panel();
            Panel printAllCarsPanel = new Panel();
            Panel addCarPanel = new Panel(new GridLayout(2));
            Panel removeCarPanel = new Panel();
            Panel removeCarCheckPanel= new Panel();
            Panel searchPersonPanel = new Panel();
            Panel addPersonPanel = new Panel(new GridLayout(2));
            Panel removePersonPanel = new Panel();
            Panel removePersonCheckPanel= new Panel();
            Panel searchRentByIdPanel = new Panel();
            Panel addRentPanel = new Panel(new GridLayout(2));
            Panel removeRentPanel = new Panel();
            Panel removeRentCheckPanel = new Panel();
            Panel addClientPanel = new Panel(new GridLayout(2));
            Panel removeClientPanel = new Panel();
            Panel removeClientCheckPanel = new Panel();
            Panel searchCarToRemovePanel = new Panel(new GridLayout(2));
            Panel searchRentToRemovePanel = new Panel(new GridLayout(2));
            Panel editCarPanel = new Panel();
            Panel editSearchedCarPanel = new Panel(new GridLayout(2));
            Panel editPersonPanel = new Panel();
            Panel editSearchedPersonPanel = new Panel(new GridLayout(2));
            Panel searchEmployeeByIdPanel = new Panel();
            Panel addEmployeePanel = new Panel(new GridLayout(2));
            Panel editEmployeePanel = new Panel();
            Panel editSearchedEmployeePanel = new Panel(new GridLayout(2));
            Panel removeEmployeePanel = new Panel();
            Panel removeEmployeeCheckPanel = new Panel();
            Panel addReservationPanel = new Panel(new GridLayout(2));
            Panel removeReservationPanel = new Panel();
            Panel removeReservationCheckPanel = new Panel();
            Panel searchReservationToRemovePanel = new Panel(new GridLayout(2));
            Panel addInsurancePanel = new Panel(new GridLayout(2));
            Panel removeInsurancePanel = new Panel();
            Panel removeInsuranceCheckPanel = new Panel();
            Panel addWagePanel = new Panel(new GridLayout(2));
            Panel editWagePanel = new Panel();
            Panel editSearchedWagePanel = new Panel(new GridLayout(2));
            Panel removeWagePanel = new Panel();
            Panel removeWageCheckPanel = new Panel();
            Panel addVehicleInspectionPanel = new Panel(new GridLayout(2));
            Panel removeVehicleInspectionPanel = new Panel();
            Panel removeVehicleInspectionCheckPanel = new Panel();
            Panel addFaultPanel = new Panel(new GridLayout(2));
            Panel editFaultPanel = new Panel();
            Panel editSearchedFaultPanel = new Panel(new GridLayout(2));
            Panel removeFaultPanel = new Panel();
            Panel removeFaultCheckPanel = new Panel();
            Panel checkReservationPanel = new Panel();
            Panel checkReservationByPeselPanel = new Panel();
            Panel chooseReservationToExecutePanel = new Panel(new GridLayout(2));
            Panel changeReservationToRentPanel = new Panel(new GridLayout(2));


            GridLayout gridLayout = (GridLayout)contentPanel.getLayoutManager();
            gridLayout.setHorizontalSpacing(10);
            gridLayout.setVerticalSpacing(0);

            GridLayout gridLayoutAddCar = (GridLayout)addCarPanel.getLayoutManager();
            gridLayoutAddCar.setHorizontalSpacing(10);
            gridLayoutAddCar.setVerticalSpacing(1);

            GridLayout gridLayoutAddPerson = (GridLayout) addPersonPanel.getLayoutManager();
            gridLayoutAddPerson.setHorizontalSpacing(10);
            gridLayoutAddPerson.setVerticalSpacing(1);

            GridLayout gridLayoutAddRent = (GridLayout) addRentPanel.getLayoutManager();
            gridLayoutAddRent.setHorizontalSpacing(10);
            gridLayoutAddRent.setVerticalSpacing(1);

            GridLayout gridLayoutAddClient = (GridLayout) addClientPanel.getLayoutManager();
            gridLayoutAddClient.setHorizontalSpacing(10);
            gridLayoutAddClient.setVerticalSpacing(1);

            GridLayout gridLayoutSearchCarToRemove = (GridLayout) searchCarToRemovePanel.getLayoutManager();
            gridLayoutSearchCarToRemove.setHorizontalSpacing(10);
            gridLayoutSearchCarToRemove.setVerticalSpacing(1);

            GridLayout gridLayoutSearchRentToRemove = (GridLayout) searchRentToRemovePanel.getLayoutManager();
            gridLayoutSearchRentToRemove.setHorizontalSpacing(10);
            gridLayoutSearchRentToRemove.setVerticalSpacing(1);

            GridLayout gridLayoutEditCar = (GridLayout) editSearchedCarPanel.getLayoutManager();
            gridLayoutEditCar.setHorizontalSpacing(10);
            gridLayoutEditCar.setVerticalSpacing(1);

            GridLayout gridLayoutEditPerson = (GridLayout) editSearchedPersonPanel.getLayoutManager();
            gridLayoutEditPerson.setHorizontalSpacing(10);
            gridLayoutEditPerson.setVerticalSpacing(1);

            GridLayout gridLayoutAddEmployee = (GridLayout) addEmployeePanel.getLayoutManager();
            gridLayoutAddEmployee.setHorizontalSpacing(10);
            gridLayoutAddEmployee.setVerticalSpacing(1);

            GridLayout gridLayoutEditEmployee = (GridLayout) editSearchedEmployeePanel.getLayoutManager();
            gridLayoutEditEmployee.setHorizontalSpacing(10);
            gridLayoutEditEmployee.setVerticalSpacing(1);

            GridLayout gridLayoutAddReservation = (GridLayout) addReservationPanel.getLayoutManager();
            gridLayoutAddReservation.setHorizontalSpacing(10);
            gridLayoutAddReservation.setVerticalSpacing(1);

            GridLayout gridLayoutSearchReservationToRemove = (GridLayout) searchReservationToRemovePanel.getLayoutManager();
            gridLayoutSearchReservationToRemove.setHorizontalSpacing(10);
            gridLayoutSearchReservationToRemove.setVerticalSpacing(1);

            GridLayout gridLayoutAddInsurance = (GridLayout)addInsurancePanel.getLayoutManager();
            gridLayoutAddInsurance.setHorizontalSpacing(10);
            gridLayoutAddInsurance.setVerticalSpacing(1);

            GridLayout gridLayoutAddWage = (GridLayout)addWagePanel.getLayoutManager();
            gridLayoutAddWage.setHorizontalSpacing(10);
            gridLayoutAddWage.setVerticalSpacing(1);

            GridLayout gridLayoutEditWage = (GridLayout) editSearchedWagePanel.getLayoutManager();
            gridLayoutEditWage.setHorizontalSpacing(10);
            gridLayoutEditWage.setVerticalSpacing(1);

            GridLayout gridLayoutAddVehicleInspection = (GridLayout)addVehicleInspectionPanel.getLayoutManager();
            gridLayoutAddVehicleInspection.setHorizontalSpacing(10);
            gridLayoutAddVehicleInspection.setVerticalSpacing(1);

            GridLayout gridLayoutAddFault = (GridLayout)addFaultPanel.getLayoutManager();
            gridLayoutAddFault.setHorizontalSpacing(10);
            gridLayoutAddFault.setVerticalSpacing(1);

            GridLayout gridLayoutEditFault = (GridLayout) editSearchedFaultPanel.getLayoutManager();
            gridLayoutEditFault.setHorizontalSpacing(10);
            gridLayoutEditFault.setVerticalSpacing(1);

            GridLayout gridLayoutChooseRent = (GridLayout) chooseReservationToExecutePanel.getLayoutManager();
            gridLayoutChooseRent.setHorizontalSpacing(10);
            gridLayoutChooseRent.setVerticalSpacing(1);

            GridLayout gridLayoutChangeReservationToRent = (GridLayout) changeReservationToRentPanel.getLayoutManager();
            gridLayoutChangeReservationToRent.setHorizontalSpacing(10);
            gridLayoutChangeReservationToRent.setVerticalSpacing(1);


            Label menuTitle = new Label("MAIN MANU");
            menuTitle.setLayoutData(GridLayout.createLayoutData(
                    GridLayout.Alignment.CENTER,
                    GridLayout.Alignment.CENTER,
                    true,
                    false,
                    15,
                    10
            ));
            contentPanel.addComponent(menuTitle);

            contentPanel.addComponent(new Label("CAR MANAGEMENT:"));
            contentPanel.addComponent(new Label(""));

/***************************************SEARCHING BY ID**************************************************************/

            Label searchCarByIdLabel = new Label("Search car by Id");
            contentPanel.addComponent(searchCarByIdLabel);

            contentPanel.addComponent(new Button("Search", () ->{
                TextBox input = new TextBox();
                searchCarByIdPanel
                        .addComponent(new Label("Enter Car's id:"))
                        .addComponent(input)
                        .addComponent(new Button("Search", () ->{
                            List<Car> carList = carController.searchCarById(Long.parseLong(input.getText()));
                            if(carList.isEmpty()){
                                MessageDialog.showMessageDialog(textGUI, "Car with id you searched:", "There is no cars with that id",MessageDialogButton.OK);
                            }else {
                                MessageDialog.showMessageDialog(textGUI, "Car with id you searched:", carList.toString(), MessageDialogButton.OK);
                            }
                        }
                        ))
                        .addComponent(new Button("Close", () -> textGUI.removeWindow(searchCarByIdWindow)).setLayoutData(GridLayout.createHorizontallyEndAlignedLayoutData(2)));
                textGUI.addWindowAndWait(searchCarByIdWindow);
                searchCarByIdPanel.removeAllComponents();
            }));


/***************************************SEARCHING BY MODEL**************************************************************/



            Label searchCarByModelLabel = new Label("Search car by model");
            contentPanel.addComponent(searchCarByModelLabel);

            contentPanel.addComponent(new Button("Search", () ->{
                TextBox input = new TextBox();
                searchCarByModelPanel
                        .addComponent(new Label("Enter model:"))
                        .addComponent(input)
                        .addComponent(new Button("Search", () ->{
                            List<Car> carList = carController.searchCarByModel(input.getText());
                            if(carList.isEmpty()){
                                MessageDialog.showMessageDialog(textGUI, "Cars with model you searched:", "There are no cars with that model",MessageDialogButton.OK);
                            }else {
                                MessageDialog.showMessageDialog(textGUI, "Cars with model you searched:", carList.toString(), MessageDialogButton.OK);
                            }
                        }
                        ))
                        .addComponent(new Button("Close", () -> textGUI.removeWindow(searchCarByModelWindow)).setLayoutData(GridLayout.createHorizontallyEndAlignedLayoutData(2)));
                textGUI.addWindowAndWait(searchCarByModelWindow);
                searchCarByModelPanel.removeAllComponents();
            }));


/***************************************SEARCHING BY VIN**************************************************************/


            Label searchCarByVINLabel = new Label("Search car by VIN");
            contentPanel.addComponent(searchCarByVINLabel);

            contentPanel.addComponent(new Button("Search", () ->{
                TextBox input = new TextBox();
                searchCarByVINPanel
                        .addComponent(new Label("Enter Car's VIN number:"))
                        .addComponent(input)
                        .addComponent(new Button("Search", () ->{
                            List<Car> carList = carController.searchCarByVIN(input.getText());
                            if(carList.isEmpty()){
                                MessageDialog.showMessageDialog(textGUI, "Cars with VIN number you searched:", "There are no cars with that VIN number",MessageDialogButton.OK);
                            }else {
                                MessageDialog.showMessageDialog(textGUI, "Cars with VIN number you searched:", carList.toString(), MessageDialogButton.OK);
                            }
                        }
                        ))
                        .addComponent(new Button("Close", () -> textGUI.removeWindow(searchCarByVINWindow)).setLayoutData(GridLayout.createHorizontallyEndAlignedLayoutData(2)));
                textGUI.addWindowAndWait(searchCarByVINWindow);
                searchCarByVINPanel.removeAllComponents();
            }));




/***************************************SEARCHING BY BRAND**************************************************************/


            Label searchCarByBrandLabel = new Label("Search car by brand");
            contentPanel.addComponent(searchCarByBrandLabel);

            contentPanel.addComponent(new Button("Search", () ->{
                TextBox input = new TextBox();
                searchCarByBrandPanel
                        .addComponent(new Label("Enter Car's brand:"))
                        .addComponent(input)
                        .addComponent(new Button("Search", () ->{
                            List<Car> carList = carController.searchCarByBrand(input.getText());
                            if(carList.isEmpty()){
                                MessageDialog.showMessageDialog(textGUI, "Cars with brand you searched:", "There are no cars with that brand",MessageDialogButton.OK);
                            }else {
                                MessageDialog.showMessageDialog(textGUI, "Cars with brand you searched:", carList.toString(), MessageDialogButton.OK);
                            }
                        }
                        ))
                        .addComponent(new Button("Close", () -> textGUI.removeWindow(searchCarByBrandWindow)).setLayoutData(GridLayout.createHorizontallyEndAlignedLayoutData(2)));
                textGUI.addWindowAndWait(searchCarByBrandWindow);
                searchCarByBrandPanel.removeAllComponents();
            }));



/***************************************PRINT ALL CARS***************************************************************************/


            Label printAllCarsLabel = new Label("Print all cars");
            contentPanel.addComponent(printAllCarsLabel);

            contentPanel.addComponent(new Button("Print", () ->{
                printAllCarsPanel
                        .addComponent(new Button("Print cars", () ->{
                            List<Car> carList = carController.searchAllCars();
                            if(carList.isEmpty()){
                                MessageDialog.showMessageDialog(textGUI, "All cars:", "There are no cars in database",MessageDialogButton.OK);
                            }else {
                                MessageDialog.showMessageDialog(textGUI, "All cars", carList.toString(), MessageDialogButton.OK);
                            }
                        }
                        ))
                        .addComponent(new Button("Close", () -> textGUI.removeWindow(printAllCarsWindow)).setLayoutData(GridLayout.createHorizontallyEndAlignedLayoutData(2)));
                textGUI.addWindowAndWait(printAllCarsWindow);
                printAllCarsPanel.removeAllComponents();
            }));


/***************************************ADDING CAR**************************************************************/


            Label addCarLabel = new Label("Add Car");
            contentPanel.addComponent(addCarLabel);

            contentPanel.addComponent(new Button("Add Car", () ->{
                TextBox brandInput = new TextBox();
                TextBox modelInput = new TextBox();
                TextBox licensePlateInput = new TextBox();
                TextBox productionYearInput = new TextBox();
                TextBox mileageInput = new TextBox();
                TextBox fuelInput = new TextBox();
                TextBox VINInput = new TextBox();
                TextBox priceInput = new TextBox();
                addCarPanel
                        .addComponent(new Label("Enter Car's brand:"))
                        .addComponent(brandInput)
                        .addComponent(new Label("Enter Car's model:"))
                        .addComponent(modelInput)
                        .addComponent(new Label("Enter Car's license plate:"))
                        .addComponent(licensePlateInput)
                        .addComponent(new Label("Enter Car's productionYear:"))
                        .addComponent(productionYearInput)
                        .addComponent(new Label("Enter Car's mileage:"))
                        .addComponent(mileageInput)
                        .addComponent(new Label("Enter Car's type of fuel:"))
                        .addComponent(fuelInput)
                        .addComponent(new Label("Enter Car's VIN number:"))
                        .addComponent(VINInput)
                        .addComponent(new Label("Enter Car's price:"))
                        .addComponent(priceInput)
                        .addComponent(new Button("Close", () -> textGUI.removeWindow(addCarWindow)).setLayoutData(GridLayout.createHorizontallyEndAlignedLayoutData(2)))
                        .addComponent(new Button("Add", () -> {
                            Car car = new Car(brandInput.getText(),modelInput.getText(),licensePlateInput.getText(),Long.parseLong(productionYearInput.getText()),Long.parseLong(mileageInput.getText()),fuelInput.getText(),VINInput.getText(), Double.parseDouble(priceInput.getText()));
                            if(carController.exist(car)){
                                MessageDialog.showMessageDialog(textGUI, "Information", "Car already exists", MessageDialogButton.OK);
                            }else {
                                carController.addCar(car);
                                MessageDialog.showMessageDialog(textGUI, "Information", "Car was successfully added", MessageDialogButton.OK);
                            }
                }));
                textGUI.addWindowAndWait(addCarWindow);
                addCarPanel.removeAllComponents();
            }));


/***************************************EDIT CAR**************************************************************/


            Label editCarLabel = new Label("Edit Car");
            contentPanel.addComponent(editCarLabel);

            contentPanel.addComponent(new Button("Edit Car",()->{
                TextBox input = new TextBox();
                editCarPanel
                        .addComponent(new Label("Enter car's VIN:"))
                        .addComponent(input)
                        .addComponent(new Button("Search", ()->{
                            List<Car> carList = carController.searchOneCarByVIN(input.getText());
                            if(carList.isEmpty()){
                                MessageDialog.showMessageDialog(textGUI, "Edit car", "There are no cars with that VIN",MessageDialogButton.OK);
                            }else {
                                TextBox brandInput = new TextBox();
                                brandInput.setText(carList.get(0).getBrand());
                                TextBox modelInput = new TextBox();
                                modelInput.setText(carList.get(0).getModel());
                                TextBox licensePlateInput = new TextBox();
                                licensePlateInput.setText(carList.get(0).getLicensePlate());
                                TextBox productionYearInput = new TextBox();
                                productionYearInput.setText(String.valueOf(carList.get(0).getProductionDate()));
                                TextBox mileageInput = new TextBox();
                                mileageInput.setText(String.valueOf(carList.get(0).getMileage()));
                                TextBox fuelInput = new TextBox();
                                fuelInput.setText(carList.get(0).getFuel());
                                TextBox VINInput = new TextBox();
                                VINInput.setText(carList.get(0).getVIN());
                                TextBox priceInput = new TextBox();
                                priceInput.setText(String.valueOf(carList.get(0).getPrice()));
                                editSearchedCarPanel
                                        .addComponent(new Label("Change Car's brand:"))
                                        .addComponent(brandInput)
                                        .addComponent(new Label("Change Car's model:"))
                                        .addComponent(modelInput)
                                        .addComponent(new Label("Change Car's license plate:"))
                                        .addComponent(licensePlateInput)
                                        .addComponent(new Label("Change Car's productionYear:"))
                                        .addComponent(productionYearInput)
                                        .addComponent(new Label("Change Car's mileage:"))
                                        .addComponent(mileageInput)
                                        .addComponent(new Label("Change Car's type of fuel:"))
                                        .addComponent(fuelInput)
                                        .addComponent(new Label("Change Car's VIN number:"))
                                        .addComponent(VINInput)
                                        .addComponent(new Label("Change Car's price:"))
                                        .addComponent(priceInput)
                                        .addComponent(new Button("Edit", ()->{
                                            carList.get(0).setBrand(brandInput.getText());
                                            carList.get(0).setModel(modelInput.getText());
                                            carList.get(0).setLicensePlate(licensePlateInput.getText());
                                            carList.get(0).setProductionDate(Long.parseLong(productionYearInput.getText()));
                                            carList.get(0).setMileage(Long.parseLong(mileageInput.getText()));
                                            carList.get(0).setFuel(fuelInput.getText());
                                            carList.get(0).setVIN(VINInput.getText());
                                            carList.get(0).setPrice(Double.parseDouble(priceInput.getText()));
                                            carController.updateCar(carList.get(0));
                                            MessageDialog.showMessageDialog(textGUI,"Information", "Car has been edited.", MessageDialogButton.OK);
                                            textGUI.removeWindow(editSearchedCarWindow);
                                            editSearchedCarPanel.removeAllComponents();
                                        }));
                                editSearchedCarPanel.addComponent(new Button("close", () -> textGUI.removeWindow(editSearchedCarWindow)));
                                textGUI.addWindowAndWait(editSearchedCarWindow);
                                editSearchedCarPanel.removeAllComponents();
                            }
                        }));
                editCarPanel.addComponent(new Button("close", () -> textGUI.removeWindow(editCarWindow)));
                textGUI.addWindowAndWait(editCarWindow);
                editCarPanel.removeAllComponents();
            }));



/***************************************REMOVING CAR**************************************************************/


            Label removeCarLabel = new Label("Remove Car");
            contentPanel.addComponent(removeCarLabel);

            contentPanel.addComponent(new Button("Remove Car", () ->{
                TextBox input = new TextBox();
                removeCarPanel
                        .addComponent(new Label("Enter Car's VIN:"))
                        .addComponent(input)
                        .addComponent(new Button("Search", ()->{
                            List<Car> carList = carController.searchCarByVIN(input.getText());
                            if(carList.isEmpty()){
                                MessageDialog.showMessageDialog(textGUI, "Remove car", "There are no cars with that VIN",MessageDialogButton.OK);
                            }else {
                               for(Car c : carList){
                                   searchCarToRemovePanel
                                           .addComponent(new Label(c.toString()))
                                           .addComponent(new Button("Remove", ()->{
                                               removeCarCheckPanel
                                                       .addComponent(new Label("Are You sure you want to delete this car permanently?"))
                                                       .addComponent(new Button("Yes", ()->{
                                                           if(carController.isRented(c)){
                                                               MessageDialog.showMessageDialog(textGUI, "Remove car", "Car is rented, therefore it cannot be removed", MessageDialogButton.OK);
                                                           }else {
                                                               carController.deleteCar(c);
                                                               MessageDialog.showMessageDialog(textGUI, "Remove car", "Car was successfully removed.", MessageDialogButton.OK);
                                                               textGUI.removeWindow(removeCarCheckWindow);
                                                               removeCarCheckPanel.removeAllComponents();
                                                               textGUI.removeWindow(searchCarToRemoveWindow);
                                                               searchCarToRemovePanel.removeAllComponents();
                                                           }
                                                       }))
                                                       .addComponent(new Button("No",()->{
                                                           textGUI.removeWindow(removeCarCheckWindow);
                                                           removeCarCheckPanel.removeAllComponents();
                                                       }));
                                               textGUI.addWindowAndWait(removeCarCheckWindow);
                                           }));
                               }
                                searchCarToRemovePanel.addComponent(new Button("Close", () -> textGUI.removeWindow(searchCarToRemoveWindow)).setLayoutData(GridLayout.createHorizontallyEndAlignedLayoutData(2)));
                                textGUI.addWindowAndWait(searchCarToRemoveWindow);
                                searchCarToRemovePanel.removeAllComponents();
                            }
                        }))
                        .addComponent(new Button("Close", () -> textGUI.removeWindow(removeCarWindow)).setLayoutData(GridLayout.createHorizontallyEndAlignedLayoutData(2)));
                textGUI.addWindowAndWait(removeCarWindow);
                removeCarPanel.removeAllComponents();
            }));


/***************************************ADDING INSURANCE**************************************************************/


            Label addInsuranceLabel = new Label("Add Insurance");
            contentPanel.addComponent(addInsuranceLabel);

            contentPanel.addComponent(new Button("Add Insurance", () ->{
                TextBox startInsureDateInput = new TextBox();
                TextBox endInsureDateInput = new TextBox();
                TextBox carVINInput = new TextBox();
                addInsurancePanel
                        .addComponent(new Label("Enter start insure date (YYYY-MM-DD):"))
                        .addComponent(startInsureDateInput)
                        .addComponent(new Label("Enter end insure date (YYYY-MM-DD):"))
                        .addComponent(endInsureDateInput)
                        .addComponent(new Label("Enter car's VIN: "))
                        .addComponent(carVINInput)
                        .addComponent(new Button("Close", () -> textGUI.removeWindow(addInsuranceWindow)).setLayoutData(GridLayout.createHorizontallyEndAlignedLayoutData(2)))
                        .addComponent(new Button("Add", () -> {
                            if(LocalDate.parse(endInsureDateInput.getText()).isBefore(LocalDate.parse(startInsureDateInput.getText()))){
                                MessageDialog.showMessageDialog(textGUI, "Information", "Start date should be before End date",MessageDialogButton.OK);
                            }else if(!carController.existCarByVIN(carVINInput.getText())){
                                MessageDialog.showMessageDialog(textGUI, "Information", "Car does not exist",MessageDialogButton.OK);
                            }else{
                                Insurance insurance = new Insurance(LocalDate.parse(startInsureDateInput.getText()),LocalDate.parse(endInsureDateInput.getText()), carController.searchCarByVIN(carVINInput.getText()).get(0));
                                if(insuranceController.hasInsurance(carVINInput.getText())){
                                    MessageDialog.showMessageDialog(textGUI, "Information", "Car already has insurance",MessageDialogButton.OK);
                                }else {
                                    insuranceController.addInsurance(insurance);
                                    MessageDialog.showMessageDialog(textGUI, "Information", "Insurance was successfully added", MessageDialogButton.OK);
                                }
                            }
                        }));
                textGUI.addWindowAndWait(addInsuranceWindow);
                addInsurancePanel.removeAllComponents();
            }));



/***************************************REMOVING INSURANCE**************************************************************/


            Label removeInsuranceLabel = new Label("Remove Insurance");
            contentPanel.addComponent(removeInsuranceLabel);

            contentPanel.addComponent(new Button("Remove Insurance", () ->{
                TextBox input = new TextBox();
                removeInsurancePanel
                        .addComponent(new Label("Enter Car's VIN to find insurance:"))
                        .addComponent(input)
                        .addComponent(new Button("Remove", () -> {
                            if(!carController.existCarByVIN(input.getText())){
                                MessageDialog.showMessageDialog(textGUI, "Information", "Car does not exist",MessageDialogButton.OK);
                            }else {
                                removeInsuranceCheckPanel
                                        .addComponent(new Label("Are You sure you want to delete this insurance permanently?"))
                                        .addComponent(new Button("Yes", ()->{
                                            List<Insurance> insuranceList = insuranceController.searchByVIN(input.getText());
                                            if(insuranceList.isEmpty()){
                                                MessageDialog.showMessageDialog(textGUI, "Remove insurance", "This car has no insurance",MessageDialogButton.OK);
                                            }else {
                                                insuranceController.deleteInsurance(insuranceList.get(0));
                                                MessageDialog.showMessageDialog(textGUI, "Remove insurance", "Insurance was successfully removed.", MessageDialogButton.OK);
                                            }
                                        }))
                                        .addComponent(new Button("No",()->{
                                            textGUI.removeWindow(removeInsuranceCheckWindow);
                                        }));
                                textGUI.addWindowAndWait(removeInsuranceCheckWindow);
                                removeInsuranceCheckPanel.removeAllComponents();
                            }
                        }))
                        .addComponent(new Button("Close", () -> textGUI.removeWindow(removeInsuranceWindow)).setLayoutData(GridLayout.createHorizontallyEndAlignedLayoutData(2)));
                textGUI.addWindowAndWait(removeInsuranceWindow);
                removeInsurancePanel.removeAllComponents();
            }));



/***************************************ADDING VEHICLE INSPECTION**************************************************************/


            Label addVehicleInspectionLabel = new Label("Add Vehicle Inspection");
            contentPanel.addComponent(addVehicleInspectionLabel);

            contentPanel.addComponent(new Button("Add Vehicle Inspection", () ->{
                TextBox validityDateInput = new TextBox();
                TextBox carVINInput = new TextBox();
                addVehicleInspectionPanel
                        .addComponent(new Label("Enter validity date (YYYY-MM-DD):"))
                        .addComponent(validityDateInput)
                        .addComponent(new Label("Enter car's VIN: "))
                        .addComponent(carVINInput)
                        .addComponent(new Button("Close", () -> textGUI.removeWindow(addVehicleInspectionWindow)).setLayoutData(GridLayout.createHorizontallyEndAlignedLayoutData(2)))
                        .addComponent(new Button("Add", () -> {
                            if(LocalDate.parse(validityDateInput.getText()).isBefore(LocalDate.now())){
                                MessageDialog.showMessageDialog(textGUI, "Information", "Validity date should be at least before today date",MessageDialogButton.OK);
                            }else if(!carController.existCarByVIN(carVINInput.getText())){
                                MessageDialog.showMessageDialog(textGUI, "Information", "Car does not exist",MessageDialogButton.OK);
                            }else{
                                VehicleInspection vehicleInspection = new VehicleInspection(LocalDate.parse(validityDateInput.getText()), carController.searchCarByVIN(carVINInput.getText()).get(0));
                                if(vehicleInspectionController.hasVehicleInspection(carVINInput.getText())){
                                    MessageDialog.showMessageDialog(textGUI, "Information", "Car already has actual Inspection",MessageDialogButton.OK);
                                }else {
                                    vehicleInspectionController.addVehicleInspection(vehicleInspection);
                                    MessageDialog.showMessageDialog(textGUI, "Information", "Vehicle Inspection was successfully added to car with VIN: " + carVINInput.getText(), MessageDialogButton.OK);
                                }
                            }
                        }));
                textGUI.addWindowAndWait(addVehicleInspectionWindow);
                addVehicleInspectionPanel.removeAllComponents();
            }));



/***************************************REMOVING VEHICLE INSPECTION**************************************************************/


            Label removeVehicleInspectionLabel = new Label("Remove Vehicle Inspection");
            contentPanel.addComponent(removeVehicleInspectionLabel);

            contentPanel.addComponent(new Button("Remove Vehicle Inspection", () ->{
                TextBox input = new TextBox();
                removeVehicleInspectionPanel
                        .addComponent(new Label("Enter Car's VIN to find this vehicle inspection:"))
                        .addComponent(input)
                        .addComponent(new Button("Remove", () -> {
                            if(!carController.existCarByVIN(input.getText())){
                                MessageDialog.showMessageDialog(textGUI, "Information", "Car does not exist",MessageDialogButton.OK);
                            }else {
                                removeVehicleInspectionCheckPanel
                                        .addComponent(new Label("Are You sure you want to delete this vehicle inspection permanently?"))
                                        .addComponent(new Button("Yes", ()->{
                                            List<VehicleInspection> vehicleInspectionList = vehicleInspectionController.searchByVIN(input.getText());
                                            if(vehicleInspectionList.isEmpty()){
                                                MessageDialog.showMessageDialog(textGUI, "Remove vehicle inspection", "This car has no vehicle inspection",MessageDialogButton.OK);
                                            }else {
                                                vehicleInspectionController.deleteVehicleInspection(vehicleInspectionList.get(0));
                                                MessageDialog.showMessageDialog(textGUI, "Remove vehicle inspection", "Vehicle inspection was successfully removed.", MessageDialogButton.OK);
                                            }
                                        }))
                                        .addComponent(new Button("No",()->{
                                            textGUI.removeWindow(removeVehicleInspectionCheckWindow);
                                        }));
                                textGUI.addWindowAndWait(removeVehicleInspectionCheckWindow);
                                removeVehicleInspectionCheckPanel.removeAllComponents();
                            }
                        }))
                        .addComponent(new Button("Close", () -> textGUI.removeWindow(removeVehicleInspectionWindow)).setLayoutData(GridLayout.createHorizontallyEndAlignedLayoutData(2)));
                textGUI.addWindowAndWait(removeVehicleInspectionWindow);
                removeVehicleInspectionPanel.removeAllComponents();
            }));


/***************************************ADDING FAULT**************************************************************/


            Label addFaultLabel = new Label("Add Fault");
            contentPanel.addComponent(addFaultLabel);

            contentPanel.addComponent(new Button("Add Fault", () ->{
                TextBox descriptionInput = new TextBox();
                CheckBoxList<Boolean> checkBoxList = new CheckBoxList<Boolean>();
                checkBoxList.addItem(true);
                checkBoxList.addItem(false);
                TextBox carVINInput = new TextBox();
                addFaultPanel
                        .addComponent(new Label("Fault description:"))
                        .addComponent(descriptionInput)
                        .addComponent(new Label("Is fixed? "))
                        .addComponent(checkBoxList)
                        .addComponent(new Label("Enter car's VIN: "))
                        .addComponent(carVINInput)
                        .addComponent(new Button("Close", () -> textGUI.removeWindow(addFaultWindow)).setLayoutData(GridLayout.createHorizontallyEndAlignedLayoutData(2)))
                        .addComponent(new Button("Add", () -> {
                            if(!carController.existCarByVIN(carVINInput.getText())){
                                MessageDialog.showMessageDialog(textGUI, "Information", "Car does not exist",MessageDialogButton.OK);
                            }else if(checkBoxList.getCheckedItems().size()>1 || checkBoxList.getCheckedItems().size()==0){
                                MessageDialog.showMessageDialog(textGUI, "Information", "Please check only one status",MessageDialogButton.OK);
                            }else{
                                Fault fault = new Fault(descriptionInput.getText(),checkBoxList.getCheckedItems().get(0),carController.searchCarByVIN(carVINInput.getText()).get(0));
                                if(faultController.hasFault(carVINInput.getText())){
                                    MessageDialog.showMessageDialog(textGUI, "Information", "Car already has fault. If you want to add fault to car with id '" + carVINInput.getText() + "' just edit it.",MessageDialogButton.OK);
                                }else {
                                    faultController.addFault(fault);
                                    MessageDialog.showMessageDialog(textGUI, "Information", "Fault was successfully added", MessageDialogButton.OK);
                                }
                            }
                        }));
                textGUI.addWindowAndWait(addFaultWindow);
                addFaultPanel.removeAllComponents();
            }));


/***************************************EDIT FAULT**************************************************************/


            Label editFaultLabel = new Label("Edit Fault");
            contentPanel.addComponent(editFaultLabel);

            contentPanel.addComponent(new Button("Edit fault",()->{
                TextBox input = new TextBox();
                editFaultPanel
                        .addComponent(new Label("Enter car's VIN:"))
                        .addComponent(input)
                        .addComponent(new Button("Search", ()->{
                            List<Fault> faultList = faultController.searchByVIN(input.getText());
                            if(faultList.isEmpty()){
                                MessageDialog.showMessageDialog(textGUI, "Edit fault", "This car has no fault",MessageDialogButton.OK);
                            }else {
                                TextBox descriptionInput = new TextBox();
                                CheckBoxList<Boolean> checkBoxList = new CheckBoxList<Boolean>();
                                checkBoxList.addItem(true);
                                checkBoxList.addItem(false);
                                descriptionInput.setText(faultList.get(0).getDescription());
                                checkBoxList.setChecked(faultList.get(0).getFixedStatus(), true);
                                editSearchedFaultPanel
                                        .addComponent(new Label("Change description:"))
                                        .addComponent(descriptionInput)
                                        .addComponent(new Label("Change fixed status:"))
                                        .addComponent(checkBoxList)
                                        .addComponent(new Button("Edit", ()->{
                                            if(checkBoxList.getCheckedItems().size()>1 || checkBoxList.getCheckedItems().size()==0){
                                                MessageDialog.showMessageDialog(textGUI, "Information", "Please check one status",MessageDialogButton.OK);
                                            }else{
                                                faultList.get(0).setDescription(descriptionInput.getText());
                                                faultList.get(0).setFixedStatus(checkBoxList.getCheckedItems().get(0));
                                                faultController.updateFault(faultList.get(0));
                                                MessageDialog.showMessageDialog(textGUI,"Information", "Fault has been edited.", MessageDialogButton.OK);
                                                textGUI.removeWindow(editSearchedFaultWindow);
                                                editSearchedFaultPanel.removeAllComponents();
                                            }
                                        }));
                                editSearchedFaultPanel.addComponent(new Button("close", () -> textGUI.removeWindow(editSearchedFaultWindow)));
                                textGUI.addWindowAndWait(editSearchedFaultWindow);
                                editSearchedFaultPanel.removeAllComponents();
                            }
                        }));
                editFaultPanel.addComponent(new Button("close", () -> textGUI.removeWindow(editFaultWindow)));
                textGUI.addWindowAndWait(editFaultWindow);
                editFaultPanel.removeAllComponents();
            }));



/***************************************REMOVING FAULT**************************************************************/


            Label removeFaultLabel = new Label("Remove Fault");
            contentPanel.addComponent(removeFaultLabel);

            contentPanel.addComponent(new Button("Remove Fault", () ->{
                TextBox input = new TextBox();
                removeFaultPanel
                        .addComponent(new Label("Enter car's VIN:"))
                        .addComponent(input)
                        .addComponent(new Button("Remove", () -> {
                            List<Fault> faultList = faultController.searchByVIN(input.getText());
                            if(faultList.isEmpty()){
                                MessageDialog.showMessageDialog(textGUI, "Remove fault", "This car has no fault ",MessageDialogButton.OK);
                            }else{
                                removeFaultCheckPanel
                                        .addComponent(new Label("Are You sure you want to remove this car's fault permanently?"))
                                        .addComponent(new Button("Yes", ()->{
                                            faultController.deleteFault(faultList.get(0));
                                            MessageDialog.showMessageDialog(textGUI, "Remove fault", "Fault was successfully removed.", MessageDialogButton.OK);
                                            removeFaultCheckPanel.removeAllComponents();
                                            textGUI.removeWindow(removeFaultCheckWindow);
                                        }))
                                        .addComponent(new Button("No",()->{
                                            textGUI.removeWindow(removeFaultCheckWindow);
                                            removeFaultCheckPanel.removeAllComponents();
                                        }));
                                textGUI.addWindowAndWait(removeFaultCheckWindow);
                                removeFaultCheckPanel.removeAllComponents();
                            }
                        }))
                        .addComponent(new Button("Close", () -> textGUI.removeWindow(removeFaultWindow)).setLayoutData(GridLayout.createHorizontallyEndAlignedLayoutData(2)));
                textGUI.addWindowAndWait(removeFaultWindow);
                removeFaultPanel.removeAllComponents();
            }));




            contentPanel.addComponent(new Label(""));
            contentPanel.addComponent(new Label(""));

            contentPanel.addComponent(new Label("PERSON MANAGEMENT:"));
            contentPanel.addComponent(new Label(""));


/***************************************SEARCH PERSON BY PESEL**************************************************************/


            Label searchPersonLabel = new Label("Search Person");
            contentPanel.addComponent(searchPersonLabel);

            contentPanel.addComponent(new Button("Search", () ->{
                TextBox input = new TextBox();
                searchPersonPanel
                        .addComponent(new Label("Enter Person pesel:"))
                        .addComponent(input)
                        .addComponent(new Button("Search", () ->{
                            List<Person> personList = personController.searchPersonByPesel(input.getText());
                            if(personList.isEmpty()){
                                MessageDialog.showMessageDialog(textGUI, "Person with pesel you searched:", "There is no persons with that pesel",MessageDialogButton.OK);
                            }else {
                                MessageDialog.showMessageDialog(textGUI, "Person with pesel you searched:", personList.get(0).toString(), MessageDialogButton.OK);
                            }
                        }
                        ))
                        .addComponent(new Button("Close", () -> textGUI.removeWindow(searchPersonWindow)).setLayoutData(GridLayout.createHorizontallyEndAlignedLayoutData(2)));
                textGUI.addWindowAndWait(searchPersonWindow);
                searchPersonPanel.removeAllComponents();
            }));



/***************************************ADDING PERSON**************************************************************/


            Label addPersonLabel = new Label("Add Person");
            contentPanel.addComponent(addPersonLabel);

            contentPanel.addComponent(new Button("Add Person", () ->{
                TextBox peselInput = new TextBox();
                TextBox nameInput = new TextBox();
                TextBox surnameInput = new TextBox();
                TextBox emailInput = new TextBox();
                TextBox phoneNumberInput = new TextBox();
                addPersonPanel
                        .addComponent(new Label("Enter Person's pesel:"))
                        .addComponent(peselInput)
                        .addComponent(new Label("Enter Person's name:"))
                        .addComponent(nameInput)
                        .addComponent(new Label("Enter Person's surname:"))
                        .addComponent(surnameInput)
                        .addComponent(new Label("Enter Person's email:"))
                        .addComponent(emailInput)
                        .addComponent(new Label("Enter Person's phone number:"))
                        .addComponent(phoneNumberInput)
                        .addComponent(new Button("Close", () -> textGUI.removeWindow(addPersonWindow)).setLayoutData(GridLayout.createHorizontallyEndAlignedLayoutData(2)))
                        .addComponent(new Button("Add", () -> {
                            Person person = new Person(peselInput.getText(),nameInput.getText(),surnameInput.getText(),emailInput.getText(),Long.parseLong(phoneNumberInput.getText()));
                            if(personController.exist(person)){
                                MessageDialog.showMessageDialog(textGUI, "Information", "Person already exists", MessageDialogButton.OK);
                            }else {
                                personController.addPerson(person);
                                MessageDialog.showMessageDialog(textGUI, "Information", "Person was successfully added", MessageDialogButton.OK);
                            }
                        }));
                textGUI.addWindowAndWait(addPersonWindow);
                addPersonPanel.removeAllComponents();
            }));


/***************************************EDIT PERSON**************************************************************/


            Label editPersonLabel = new Label("Edit Person");
            contentPanel.addComponent(editPersonLabel);

            contentPanel.addComponent(new Button("Edit person",()->{
                TextBox input = new TextBox();
                editPersonPanel
                        .addComponent(new Label("Enter person's pesel:"))
                        .addComponent(input)
                        .addComponent(new Button("Search", ()->{
                            List<Person> personList = personController.searchPersonByPesel(input.getText());
                            if(personList.isEmpty()){
                                MessageDialog.showMessageDialog(textGUI, "Edit person", "There is no person with that pesel",MessageDialogButton.OK);
                            }else {
                                TextBox nameInput = new TextBox();
                                nameInput.setText(personList.get(0).getName());
                                TextBox surnameInput = new TextBox();
                                surnameInput.setText(personList.get(0).getSurname());
                                TextBox emailInput = new TextBox();
                                emailInput.setText(personList.get(0).getEmail());
                                TextBox phoneNumberInput = new TextBox();
                                phoneNumberInput.setText(String.valueOf(personList.get(0).getPhone_number()));
                                editSearchedPersonPanel
                                        .addComponent(new Label("Change Person's name:"))
                                        .addComponent(nameInput)
                                        .addComponent(new Label("Change Person's surname:"))
                                        .addComponent(surnameInput)
                                        .addComponent(new Label("Change Person's email:"))
                                        .addComponent(emailInput)
                                        .addComponent(new Label("Change Person's phone number:"))
                                        .addComponent(phoneNumberInput)
                                        .addComponent(new Button("Edit", ()->{
                                            personList.get(0).setName(nameInput.getText());
                                            personList.get(0).setSurname(surnameInput.getText());
                                            personList.get(0).setEmail(emailInput.getText());
                                            personList.get(0).setPhone_number(Long.parseLong(phoneNumberInput.getText()));
                                            personController.updatePerson(personList.get(0));
                                            MessageDialog.showMessageDialog(textGUI,"Information", "Person has been edited.", MessageDialogButton.OK);
                                            textGUI.removeWindow(editSearchedPersonWindow);
                                            editSearchedPersonPanel.removeAllComponents();
                                        }));
                                editSearchedPersonPanel.addComponent(new Button("close", () -> textGUI.removeWindow(editSearchedPersonWindow)));
                                textGUI.addWindowAndWait(editSearchedPersonWindow);
                                editSearchedPersonPanel.removeAllComponents();
                            }
                        }));
                editPersonPanel.addComponent(new Button("close", () -> textGUI.removeWindow(editPersonWindow)));
                textGUI.addWindowAndWait(editPersonWindow);
                editPersonPanel.removeAllComponents();
            }));



/***************************************REMOVING PERSON**************************************************************/


            Label removePersonLabel = new Label("Remove Person");
            contentPanel.addComponent(removePersonLabel);

            contentPanel.addComponent(new Button("Remove Person", () ->{
                TextBox input = new TextBox();
                removePersonPanel
                        .addComponent(new Label("Enter Person's PESEL:"))
                        .addComponent(input)
                        .addComponent(new Button("Remove", () -> {
                            List<Person> personList = personController.searchPersonByPesel(input.getText());
                            if(personList.isEmpty()){
                                MessageDialog.showMessageDialog(textGUI, "Remove person", "There is no person with pesel: " + input.getText() ,MessageDialogButton.OK);
                            }else if(clientController.existClient(input.getText())){
                                MessageDialog.showMessageDialog(textGUI, "Remove person", "Cannot remove person! Exists client with id: " + input.getText() ,MessageDialogButton.OK);
                            }else if(employeeController.existEmployee(input.getText())){
                                MessageDialog.showMessageDialog(textGUI, "Remove person", "Cannot remove person! Exists employee with id: " + input.getText() ,MessageDialogButton.OK);
                            }else {
                                removePersonCheckPanel
                                        .addComponent(new Label("Are You sure you want to remove " + personList.get(0).toString() + " permanently?"))
                                        .addComponent(new Button("Yes", ()->{
                                            personController.deletePerson(personList.get(0));
                                            MessageDialog.showMessageDialog(textGUI, "Remove person", "Person was successfully removed.", MessageDialogButton.OK);
                                            removePersonCheckPanel.removeAllComponents();
                                            textGUI.removeWindow(removePersonCheckWindow);
                                        }))
                                        .addComponent(new Button("No",()->{
                                            textGUI.removeWindow(removePersonCheckWindow);
                                            removePersonCheckPanel.removeAllComponents();
                                        }));
                                textGUI.addWindowAndWait(removePersonCheckWindow);
                                removePersonCheckPanel.removeAllComponents();
                            }
                        }))
                        .addComponent(new Button("Close", () -> textGUI.removeWindow(removePersonWindow)).setLayoutData(GridLayout.createHorizontallyEndAlignedLayoutData(2)));
                textGUI.addWindowAndWait(removePersonWindow);
                removePersonPanel.removeAllComponents();
            }));



            contentPanel.addComponent(new Label(""));
            contentPanel.addComponent(new Label(""));

            contentPanel.addComponent(new Label("RENT MANAGEMENT:"));
            contentPanel.addComponent(new Label(""));


/***************************************SEARCH RENT BY CLIENT'S PESEL**************************************************************/


            Label searchRentLabel = new Label("Search Rent by client's pesel");
            contentPanel.addComponent(searchRentLabel);

            contentPanel.addComponent(new Button("Search", () ->{
                TextBox input = new TextBox();
                searchRentByIdPanel
                        .addComponent(new Label("Enter client's pesel:"))
                        .addComponent(input)
                        .addComponent(new Button("Search", () ->{
                            List<Rent> rent = rentController.searchRentByClientsPesel(input.getText());
                            if(rent.isEmpty()){
                                MessageDialog.showMessageDialog(textGUI, "Rent with client's pesel you searched:", "This client has no rented car",MessageDialogButton.OK);
                            }else {
                                MessageDialog.showMessageDialog(textGUI, "Rent with client's pesel you searched:", rent.get(0).toString(), MessageDialogButton.OK);
                            }
                        }
                        ))
                        .addComponent(new Button("Close", () -> textGUI.removeWindow(searchRentByIdWindow)).setLayoutData(GridLayout.createHorizontallyEndAlignedLayoutData(2)));
                textGUI.addWindowAndWait(searchRentByIdWindow);
                searchRentByIdPanel.removeAllComponents();
            }));



/***************************************ADDING RENT**************************************************************/


            Label addRentLabel = new Label("Add Rent");
            contentPanel.addComponent(addRentLabel);

            contentPanel.addComponent(new Button("Add Rent", () ->{
                checkReservationPanel
                        .addComponent(new Label("Does the client have a reservation?"))
                        .addComponent(new Button("Yes", ()->{
                            TextBox peselInput = new TextBox();
                            checkReservationByPeselPanel
                                    .addComponent(new Label("Enter client's pesel: "))
                                    .addComponent(peselInput)
                                    .addComponent(new Button("Search", ()->{
                                        List<Reservation> reservationList = reservationController.searchReservationByClientsPesel(peselInput.getText());
                                        if(!clientController.existClient(peselInput.getText())){
                                            MessageDialog.showMessageDialog(textGUI, "Information", "There is no such a client", MessageDialogButton.OK);
                                        }else if(reservationList.isEmpty()){
                                            MessageDialog.showMessageDialog(textGUI, "Information", "This client has no reservations", MessageDialogButton.OK);
                                        }else {
                                            for (Reservation r : reservationList){
                                                chooseReservationToExecutePanel
                                                        .addComponent(new Label(r.toString()))
                                                        .addComponent(new Button("Execute", ()->{
                                                            TextBox employeeInput = new TextBox();
                                                            changeReservationToRentPanel
                                                                    .addComponent(new Label("Enter employee's id: "))
                                                                    .addComponent(employeeInput)
                                                                    .addComponent(new Button("Execute", ()->{
                                                                        Rent rent = new Rent(Long.parseLong(employeeInput.getText()),r.getIssueDate(),r.getReturnDate(),r.getClient(),r.getCar());
                                                                        rentController.addRent(rent);
                                                                        reservationController.deleteReservation(r);


                                                                        textGUI.removeWindow(changeReservationToRentWindow);
                                                                        changeReservationToRentPanel.removeAllComponents();
                                                                        textGUI.removeWindow(chooseReservationToExecuteWindow);
                                                                        chooseReservationToExecutePanel.removeAllComponents();
                                                                    }));
                                                            textGUI.addWindowAndWait(changeReservationToRentWindow);
                                                        }));
                                            }
                                            chooseReservationToExecutePanel.addComponent(new Button("Close", ()-> textGUI.removeWindow(chooseReservationToExecuteWindow)).setLayoutData(GridLayout.createHorizontallyEndAlignedLayoutData(2)));
                                            textGUI.addWindowAndWait(chooseReservationToExecuteWindow);
                                            chooseReservationToExecutePanel.removeAllComponents();
                                        }

                                    }));
                            checkReservationByPeselPanel.addComponent(new Button("Close", ()-> textGUI.removeWindow(checkReservationByPeselWindow)).setLayoutData(GridLayout.createHorizontallyEndAlignedLayoutData(2)));
                            textGUI.addWindowAndWait(checkReservationByPeselWindow);
                            checkReservationByPeselPanel.removeAllComponents();
                        }))
                        .addComponent(new Button("No", ()->{
                            TextBox employeeIdInput = new TextBox();
                            TextBox issueDateInput = new TextBox();
                            TextBox returnDateInput = new TextBox();
                            TextBox clientInput = new TextBox();
                            TextBox carInput = new TextBox();
                            addRentPanel
                                    .addComponent(new Label("Enter Employee's id:"))
                                    .addComponent(employeeIdInput)
                                    .addComponent(new Label("Enter issue Date (YYYY-MM-DD):"))
                                    .addComponent(issueDateInput)
                                    .addComponent(new Label("Enter return Date (YYYY-MM-DD):"))
                                    .addComponent(returnDateInput)
                                    .addComponent(new Label("Enter client's pesel: "))
                                    .addComponent(clientInput)
                                    .addComponent(new Label("Enter Car's VIN:"))
                                    .addComponent(carInput)
                                    .addComponent(new Button("Close", () -> textGUI.removeWindow(addRentWindow)).setLayoutData(GridLayout.createHorizontallyEndAlignedLayoutData(2)))
                                    .addComponent(new Button("Add", () -> {
                                        if(!employeeController.existEmployee(Long.parseLong(employeeIdInput.getText()))){
                                            MessageDialog.showMessageDialog(textGUI, "Information", "There is no such an employee", MessageDialogButton.OK);
                                        }else if(!clientController.existClient(clientInput.getText())){
                                            MessageDialog.showMessageDialog(textGUI, "Information", "There is no such a client", MessageDialogButton.OK);
                                        }else if(!carController.existCarByVIN(carInput.getText())){
                                            MessageDialog.showMessageDialog(textGUI, "Information", "There is no such a car", MessageDialogButton.OK);
                                        }else if (!carController.isAvailable(carController.searchCarByVIN(carInput.getText()).get(0))) {
                                            MessageDialog.showMessageDialog(textGUI, "Information", "That car is not available", MessageDialogButton.OK);
                                        }else if (LocalDate.parse(returnDateInput.getText()).isBefore(LocalDate.parse(issueDateInput.getText()))){
                                            MessageDialog.showMessageDialog(textGUI, "Information", "Issue date should be before return date",MessageDialogButton.OK);
                                        }else if(!vehicleInspectionController.exist(carInput.getText())){
                                            MessageDialog.showMessageDialog(textGUI, "Information", "Car has no vehicle inspection", MessageDialogButton.OK);
                                        }else if(vehicleInspectionController.searchEntityByVIN(carInput.getText()).getValidityDate().isBefore(LocalDate.parse(returnDateInput.getText()))){
                                            MessageDialog.showMessageDialog(textGUI, "Information", "Car has no valid vehicle inspection",MessageDialogButton.OK);
                                        }else {
                                            Rent rent = new Rent(Long.parseLong(employeeIdInput.getText()), LocalDate.parse(issueDateInput.getText()), LocalDate.parse(returnDateInput.getText()),clientController.searchClientByPesel(clientInput.getText()).get(0) ,carController.searchCarByVIN(carInput.getText()).get(0));
                                            if(rentController.exist(rent)){
                                                MessageDialog.showMessageDialog(textGUI, "Information", "This rent's info has been already added", MessageDialogButton.OK);
                                            }else {
                                                rentController.addRent(rent);
                                                MessageDialog.showMessageDialog(textGUI, "Information", "Car was successfully added", MessageDialogButton.OK);
                                            }
                                        }
                                    }));
                            textGUI.addWindowAndWait(addRentWindow);
                            addRentPanel.removeAllComponents();
                        }));
                checkReservationPanel.addComponent(new Button("Close", ()-> textGUI.removeWindow(checkReservationWindow)).setLayoutData(GridLayout.createHorizontallyEndAlignedLayoutData(2)));
                textGUI.addWindowAndWait(checkReservationWindow);
                checkReservationPanel.removeAllComponents();
            }));



/***************************************RETURN CAR**************************************************************/


            Label removeRentLabel = new Label("Return Car");
            contentPanel.addComponent(removeRentLabel);

            contentPanel.addComponent(new Button("Return Car", () ->{
                TextBox input = new TextBox();
                removeRentPanel
                        .addComponent(new Label("Enter Client's pesel:"))
                        .addComponent(input)
                        .addComponent(new Button("Search", () -> {
                            List<Rent> rentList = rentController.searchRentByClientsPesel(input.getText());
                            if(!clientController.existClient(input.getText())){
                                MessageDialog.showMessageDialog(textGUI, "Return Car", "This client does not exist", MessageDialogButton.OK);
                            }else {
                                if(rentList.isEmpty()){
                                    MessageDialog.showMessageDialog(textGUI, "Return Car", "This client has no rented car.", MessageDialogButton.OK);
                                }else {
                                    for(Rent r : rentList){
                                        searchRentToRemovePanel
                                                .addComponent(new Label(r.toString()))
                                                .addComponent(new Button("Return", ()->{
                                                    removeRentCheckPanel
                                                            .addComponent(new Label("Are You sure you want to delete this rent info permanently?"))
                                                            .addComponent(new Button("Yes", ()->{
                                                                rentController.deleteRent(rentList.get(0));
                                                                MessageDialog.showMessageDialog(textGUI, "Return Car", "Rent was successfully removed.", MessageDialogButton.OK);
                                                                textGUI.removeWindow(removeRentCheckWindow);
                                                                removeRentCheckPanel.removeAllComponents();
                                                                textGUI.removeWindow(searchRentToRemoveWindow);
                                                                searchRentToRemovePanel.removeAllComponents();
                                                            }))
                                                            .addComponent(new Button("No",()->{
                                                                textGUI.removeWindow(removeRentCheckWindow);
                                                                removeRentCheckPanel.removeAllComponents();
                                                            }));
                                                    textGUI.addWindowAndWait(removeRentCheckWindow);
                                                }));
                                    }
                                    searchRentToRemovePanel.addComponent(new Button("Close", ()-> textGUI.removeWindow(searchRentToRemoveWindow)).setLayoutData(GridLayout.createHorizontallyEndAlignedLayoutData(2)));
                                    textGUI.addWindowAndWait(searchRentToRemoveWindow);
                                    searchRentToRemovePanel.removeAllComponents();
                                }
                            }
                        }))
                        .addComponent(new Button("Close", () -> textGUI.removeWindow(removeRentWindow)).setLayoutData(GridLayout.createHorizontallyEndAlignedLayoutData(2)));
                textGUI.addWindowAndWait(removeRentWindow);
                removeRentPanel.removeAllComponents();
            }));


            contentPanel.addComponent(new Label(""));
            contentPanel.addComponent(new Label(""));

            contentPanel.addComponent(new Label("CLIENT MANAGEMENT:"));
            contentPanel.addComponent(new Label(""));


/***************************************ADDING CLIENT**************************************************************/


            Label addClientLabel = new Label("Add Client");
            contentPanel.addComponent(addClientLabel);

            contentPanel.addComponent(new Button("Add Client", () ->{
                TextBox driverLicenseInput = new TextBox();
                TextBox personInput = new TextBox();
                addClientPanel
                        .addComponent(new Label("Enter Client driver license number:"))
                        .addComponent(driverLicenseInput)
                        .addComponent(new Label("Enter Person's pesel:"))
                        .addComponent(personInput)
                        .addComponent(new Button("Close", () -> textGUI.removeWindow(addClientWindow)).setLayoutData(GridLayout.createHorizontallyEndAlignedLayoutData(2)))
                        .addComponent(new Button("Add", () -> {
                            if(!personController.exist(personInput.getText())){
                                MessageDialog.showMessageDialog(textGUI, "Information", "Person does not exist",MessageDialogButton.OK);
                            }else {
                                Client client = new Client(driverLicenseInput.getText(),personController.searchPersonByPesel(personInput.getText()).get(0));
                                if(clientController.existClient(personInput.getText())){
                                    MessageDialog.showMessageDialog(textGUI, "Information", "Client already exists",MessageDialogButton.OK);
                                }else {
                                    clientController.addClient(client);
                                    MessageDialog.showMessageDialog(textGUI, "Information", "Client was successfully added", MessageDialogButton.OK);
                                }
                            }
                        }));
                textGUI.addWindowAndWait(addClientWindow);
                addClientPanel.removeAllComponents();
            }));



/***************************************REMOVING CLIENT**************************************************************/


            Label removeClientLabel = new Label("Remove Client");
            contentPanel.addComponent(removeClientLabel);

            contentPanel.addComponent(new Button("Remove Client", () ->{
                TextBox input = new TextBox();
                removeClientPanel
                        .addComponent(new Label("Enter Client's pesel:"))
                        .addComponent(input)
                        .addComponent(new Button("Remove", () -> {
                            removeClientCheckPanel
                                    .addComponent(new Label("Are You sure you want to delete this client permanently?"))
                                    .addComponent(new Button("Yes", ()->{
                                        List<Client> clientList = clientController.searchClientByPesel(input.getText());
                                        if(clientList.isEmpty()){
                                            MessageDialog.showMessageDialog(textGUI, "Remove client", "There are no clients with that id",MessageDialogButton.OK);
                                        }else {
                                            clientController.deleteClient(clientList.get(0));
                                            MessageDialog.showMessageDialog(textGUI, "Remove client", "Client was successfully removed.", MessageDialogButton.OK);
                                        }
                                    }))
                                    .addComponent(new Button("No",()->{
                                        textGUI.removeWindow(removeClientCheckWindow);
                                    }));
                            textGUI.addWindowAndWait(removeClientCheckWindow);
                            removeClientCheckPanel.removeAllComponents();
                        }))
                        .addComponent(new Button("Close", () -> textGUI.removeWindow(removeClientWindow)).setLayoutData(GridLayout.createHorizontallyEndAlignedLayoutData(2)));
                textGUI.addWindowAndWait(removeClientWindow);
                removeClientPanel.removeAllComponents();
            }));


            contentPanel.addComponent(new Label(""));
            contentPanel.addComponent(new Label(""));

            contentPanel.addComponent(new Label("EMPLOYEE MANAGEMENT:"));
            contentPanel.addComponent(new Label(""));


/***************************************SEARCH EMPLOYEE BY ID**************************************************************/

            Label searchEmployeeByIdLabel = new Label("Search employee by Id");
            contentPanel.addComponent(searchEmployeeByIdLabel);

            contentPanel.addComponent(new Button("Search", () ->{
                TextBox input = new TextBox();
                searchEmployeeByIdPanel
                        .addComponent(new Label("Enter Employee's id:"))
                        .addComponent(input)
                        .addComponent(new Button("Search", () ->{
                            List<Employee> employeeList = employeeController.searchById(Long.parseLong(input.getText()));
                            if(employeeList.isEmpty()){
                                MessageDialog.showMessageDialog(textGUI, "Employee with id you searched:", "There is no employee with that id",MessageDialogButton.OK);
                            }else {
                                MessageDialog.showMessageDialog(textGUI, "Employee with id you searched:", employeeList.toString(), MessageDialogButton.OK);
                            }
                        }
                        ))
                        .addComponent(new Button("Close", () -> textGUI.removeWindow(searchEmployeeByIdWindow)).setLayoutData(GridLayout.createHorizontallyEndAlignedLayoutData(2)));
                textGUI.addWindowAndWait(searchEmployeeByIdWindow);
                searchEmployeeByIdPanel.removeAllComponents();
            }));


/***************************************ADDING EMPLOYEE**************************************************************/


            Label addEmployeeLabel = new Label("Add Employee");
            contentPanel.addComponent(addEmployeeLabel);

            contentPanel.addComponent(new Button("Add Employee", () ->{
                TextBox employmentDateInput = new TextBox();
                TextBox personInput = new TextBox();
                TextBox wageInput = new TextBox();
                addEmployeePanel
                        .addComponent(new Label("Enter employment date (YYYY-MM-DD):"))
                        .addComponent(employmentDateInput)
                        .addComponent(new Label("Enter Person's pesel:"))
                        .addComponent(personInput)
                        .addComponent(new Label("Enter employee position: "))
                        .addComponent(wageInput)
                        .addComponent(new Button("Close", () -> textGUI.removeWindow(addEmployeeWindow)).setLayoutData(GridLayout.createHorizontallyEndAlignedLayoutData(2)))
                        .addComponent(new Button("Add", () -> {
                            if(!personController.exist(personInput.getText())){
                                MessageDialog.showMessageDialog(textGUI, "Information", "There is no person with such a pesel",MessageDialogButton.OK);
                            }else if(!wageController.existPosition(wageInput.getText())){
                                MessageDialog.showMessageDialog(textGUI, "Information", "There is no such a position",MessageDialogButton.OK);
                            }else{
                                Employee employee = new Employee(LocalDate.parse(employmentDateInput.getText()),personController.searchPersonByPesel(personInput.getText()).get(0),wageController.searchWageByPosition(wageInput.getText()).get(0));
                                if(employeeController.existEmployee(employee)){
                                    MessageDialog.showMessageDialog(textGUI, "Information", "Employee already exists",MessageDialogButton.OK);
                                }else {
                                    employeeController.addEmployee(employee);
                                    MessageDialog.showMessageDialog(textGUI, "Information", "Employee was successfully added", MessageDialogButton.OK);
                                }
                            }
                        }));
                textGUI.addWindowAndWait(addEmployeeWindow);
                addEmployeePanel.removeAllComponents();
            }));



/***************************************EDIT EMPLOYEE**************************************************************/


            Label editEmployeeLabel = new Label("Edit Employee");
            contentPanel.addComponent(editEmployeeLabel);

            contentPanel.addComponent(new Button("Edit employee",()->{
                TextBox input = new TextBox();
                editEmployeePanel
                        .addComponent(new Label("Enter employee's pesel:"))
                        .addComponent(input)
                        .addComponent(new Button("Search", ()->{
                            List<Employee> employeeList = employeeController.searchByPesel(input.getText());
                            if(employeeList.isEmpty()){
                                MessageDialog.showMessageDialog(textGUI, "Edit employee", "There is no employee with that pesel",MessageDialogButton.OK);
                            }else {
                                TextBox positionInput = new TextBox();
                                positionInput.setText(employeeList.get(0).getWage().getPosition());
                                editSearchedEmployeePanel
                                        .addComponent(new Label("Change Employee's position:"))
                                        .addComponent(positionInput)
                                        .addComponent(new Button("Edit", ()->{
                                            if(!wageController.existPosition(positionInput.getText())){
                                                MessageDialog.showMessageDialog(textGUI, "Information", "There is no such a position",MessageDialogButton.OK);
                                            }else{
                                                employeeList.get(0).setWage(wageController.searchWageByPosition(positionInput.getText()).get(0));
                                                employeeController.updateEmployee(employeeList.get(0));
                                                MessageDialog.showMessageDialog(textGUI,"Information", "Employee has been edited.", MessageDialogButton.OK);
                                                textGUI.removeWindow(editSearchedEmployeeWindow);
                                                editSearchedEmployeePanel.removeAllComponents();
                                            }
                                        }));
                                editSearchedEmployeePanel.addComponent(new Button("close", () -> textGUI.removeWindow(editSearchedEmployeeWindow)));
                                textGUI.addWindowAndWait(editSearchedEmployeeWindow);
                                editSearchedEmployeePanel.removeAllComponents();
                            }
                        }));
                editEmployeePanel.addComponent(new Button("close", () -> textGUI.removeWindow(editEmployeeWindow)));
                textGUI.addWindowAndWait(editEmployeeWindow);
                editEmployeePanel.removeAllComponents();
            }));



/***************************************REMOVING EMPLOYEE**************************************************************/


            Label removeEmployeeLabel = new Label("Remove Employee");
            contentPanel.addComponent(removeEmployeeLabel);

            contentPanel.addComponent(new Button("Remove Employee", () ->{
                TextBox input = new TextBox();
                removeEmployeePanel
                        .addComponent(new Label("Enter Employee's pesel:"))
                        .addComponent(input)
                        .addComponent(new Button("Remove", () -> {
                            removeEmployeeCheckPanel
                                    .addComponent(new Label("Are You sure you want to delete this employee permanently?"))
                                    .addComponent(new Button("Yes", ()->{
                                        List<Employee> employeeList = employeeController.searchByPesel(input.getText());
                                        if(employeeList.isEmpty()){
                                            MessageDialog.showMessageDialog(textGUI, "Remove employee", "There are no employees with that pesel",MessageDialogButton.OK);
                                        }else {
                                            employeeController.deleteEmployee(employeeList.get(0));
                                            MessageDialog.showMessageDialog(textGUI, "Remove employee", "Employee was successfully removed.", MessageDialogButton.OK);
                                        }
                                    }))
                                    .addComponent(new Button("No",()->{
                                        textGUI.removeWindow(removeEmployeeCheckWindow);
                                    }));
                            textGUI.addWindowAndWait(removeEmployeeCheckWindow);
                            removeEmployeeCheckPanel.removeAllComponents();
                        }))
                        .addComponent(new Button("Close", () -> textGUI.removeWindow(removeEmployeeWindow)).setLayoutData(GridLayout.createHorizontallyEndAlignedLayoutData(2)));
                textGUI.addWindowAndWait(removeEmployeeWindow);
                removeEmployeePanel.removeAllComponents();
            }));


            contentPanel.addComponent(new Label(""));
            contentPanel.addComponent(new Label(""));

            contentPanel.addComponent(new Label("RESERVATION MANAGEMENT:"));
            contentPanel.addComponent(new Label(""));

/***************************************ADD RESERVATION**************************************************************/

            Label addReservationLabel = new Label("Add Reservation");
            contentPanel.addComponent(addReservationLabel);

            contentPanel.addComponent(new Button("Add Reservation", () ->{
                TextBox issueDateInput = new TextBox();
                TextBox returnDateInput = new TextBox();
                TextBox clientPeselInput = new TextBox();
                TextBox carVINInput = new TextBox();
                addReservationPanel
                        .addComponent(new Label("Enter issue date (YYYY-MM-DD):"))
                        .addComponent(issueDateInput)
                        .addComponent(new Label("Enter return date (YYYY-MM-DD):"))
                        .addComponent(returnDateInput)
                        .addComponent(new Label("Enter Client's pesel:"))
                        .addComponent(clientPeselInput)
                        .addComponent(new Label("Enter Car's VIN:"))
                        .addComponent(carVINInput)
                        .addComponent(new Button("Close", () -> textGUI.removeWindow(addReservationWindow)).setLayoutData(GridLayout.createHorizontallyEndAlignedLayoutData(2)))
                        .addComponent(new Button("Add", () -> {
                            if(!clientController.existClient(clientPeselInput.getText())){
                                MessageDialog.showMessageDialog(textGUI, "Information", "Client does not exist",MessageDialogButton.OK);
                            }else if (!carController.existCarByVIN(carVINInput.getText())){
                                MessageDialog.showMessageDialog(textGUI, "Information", "Car does not exist",MessageDialogButton.OK);
                            }else if (carController.carReserved(carVINInput.getText(), LocalDate.parse(issueDateInput.getText()), LocalDate.parse(returnDateInput.getText()))){
                                MessageDialog.showMessageDialog(textGUI, "Information", "In this time this car is already reserved",MessageDialogButton.OK);
                            }else if (carController.carRented(carVINInput.getText(), LocalDate.parse(issueDateInput.getText()))){
                                MessageDialog.showMessageDialog(textGUI, "Information", "In this time this car is still rented",MessageDialogButton.OK);
                            }else if (LocalDate.parse(returnDateInput.getText()).isBefore(LocalDate.parse(issueDateInput.getText()))){
                                MessageDialog.showMessageDialog(textGUI, "Information", "Issue date should be before return date",MessageDialogButton.OK);
                            }else {
                                Reservation reservation = new Reservation(LocalDate.parse(issueDateInput.getText()), LocalDate.parse(returnDateInput.getText()),clientController.searchClientByPesel(clientPeselInput.getText()).get(0),carController.searchCarByVIN(carVINInput.getText()).get(0));
                                reservationController.addReservation(reservation);
                                MessageDialog.showMessageDialog(textGUI, "Information", "Reservation was successfully added", MessageDialogButton.OK);
                            }
                        }));
                textGUI.addWindowAndWait(addReservationWindow);
                addReservationPanel.removeAllComponents();
            }));



/***************************************REMOVING OUT OF DATE RESERVATIONS**************************************************************/

            Label removingOutOfDateReservationLabel = new Label("Remove out of date reservations");
            contentPanel.addComponent(removingOutOfDateReservationLabel);
            contentPanel.addComponent(new Button("Remove",()->{
                reservationController.removeOutOfDateReservations();
                MessageDialog.showMessageDialog(textGUI, "Information", "Reservations which should have been executed on the previous day (" + LocalDate.now().minusDays(1) + ") have been removed",MessageDialogButton.OK);
            }));



/***************************************REMOVE RESERVATION**************************************************************/


            Label removeReservationLabel = new Label("Remove reservation");
            contentPanel.addComponent(removeReservationLabel);

            contentPanel.addComponent(new Button("Remove Reservation", () ->{
                TextBox input = new TextBox();
                removeReservationPanel
                        .addComponent(new Label("Enter Client's pesel:"))
                        .addComponent(input)
                        .addComponent(new Button("Search", () -> {
                            List<Reservation> reservationList = reservationController.searchReservationByClientsPesel(input.getText());
                            if(!clientController.existClient(input.getText())){
                                MessageDialog.showMessageDialog(textGUI, "Remove Reservation", "This client does not exist", MessageDialogButton.OK);
                            }else {
                                if(reservationList.isEmpty()){
                                    MessageDialog.showMessageDialog(textGUI, "Remove Reservation", "This client has no reservations", MessageDialogButton.OK);
                                }else {
                                    for(Reservation r : reservationList){
                                        searchReservationToRemovePanel
                                                .addComponent(new Label(r.toString()))
                                                .addComponent(new Button("Remove", ()->{
                                                    removeReservationCheckPanel
                                                            .addComponent(new Label("Are You sure you want to delete this reservation info permanently?"))
                                                            .addComponent(new Button("Yes", ()->{
                                                                reservationController.deleteReservation(r);
                                                                MessageDialog.showMessageDialog(textGUI, "Remove reservation", "Reservation was successfully removed.", MessageDialogButton.OK);
                                                                textGUI.removeWindow(removeReservationCheckWindow);
                                                                removeReservationCheckPanel.removeAllComponents();
                                                                textGUI.removeWindow(searchReservationToRemoveWindow);
                                                                searchReservationToRemovePanel.removeAllComponents();
                                                            }))
                                                            .addComponent(new Button("No",()->{
                                                                textGUI.removeWindow(removeReservationCheckWindow);
                                                                removeReservationCheckPanel.removeAllComponents();
                                                            }));
                                                    textGUI.addWindowAndWait(removeReservationCheckWindow);
                                                }));
                                    }
                                    searchReservationToRemovePanel.addComponent(new Button("Close", ()-> textGUI.removeWindow(searchReservationToRemoveWindow)).setLayoutData(GridLayout.createHorizontallyEndAlignedLayoutData(2)));
                                    textGUI.addWindowAndWait(searchReservationToRemoveWindow);
                                    searchReservationToRemovePanel.removeAllComponents();
                                }
                            }
                        }))
                        .addComponent(new Button("Close", () -> textGUI.removeWindow(removeReservationWindow)).setLayoutData(GridLayout.createHorizontallyEndAlignedLayoutData(2)));
                textGUI.addWindowAndWait(removeReservationWindow);
                removeReservationPanel.removeAllComponents();
            }));


            contentPanel.addComponent(new Label(""));
            contentPanel.addComponent(new Label(""));

            contentPanel.addComponent(new Label("WAGE MANAGEMENT:"));
            contentPanel.addComponent(new Label(""));


/***************************************ADDING WAGE**************************************************************/


            Label addWageLabel = new Label("Add Wage");
            contentPanel.addComponent(addWageLabel);

            contentPanel.addComponent(new Button("Add Wage", () ->{
                TextBox positionInput = new TextBox();
                TextBox wageInput = new TextBox();
                addWagePanel
                        .addComponent(new Label("Enter new position:"))
                        .addComponent(positionInput)
                        .addComponent(new Label("Enter wage of new position: "))
                        .addComponent(wageInput)
                        .addComponent(new Button("Close", () -> textGUI.removeWindow(addWageWindow)).setLayoutData(GridLayout.createHorizontallyEndAlignedLayoutData(2)))
                        .addComponent(new Button("Add", () -> {
                            if(wageController.existPosition(positionInput.getText())){
                                MessageDialog.showMessageDialog(textGUI, "Information", "This position already exists",MessageDialogButton.OK);
                            }else{
                                Wage wage = new Wage(positionInput.getText(),Double.parseDouble(wageInput.getText()));
                                wageController.addWage(wage);
                                MessageDialog.showMessageDialog(textGUI, "Information", "Wage was successfully added", MessageDialogButton.OK);
                            }
                        }));
                textGUI.addWindowAndWait(addWageWindow);
                addWagePanel.removeAllComponents();
            }));



/***************************************EDIT WAGE**************************************************************/


            Label editWageLabel = new Label("Edit Wage");
            contentPanel.addComponent(editWageLabel);

            contentPanel.addComponent(new Button("Edit wage",()->{
                TextBox input = new TextBox();
                editWagePanel
                        .addComponent(new Label("Enter position:"))
                        .addComponent(input)
                        .addComponent(new Button("Search", ()->{
                            List<Wage> wageList = wageController.searchWageByPosition(input.getText());
                            if(wageList.isEmpty()){
                                MessageDialog.showMessageDialog(textGUI, "Edit wage", "There is no position: " + input.getText() ,MessageDialogButton.OK);
                            }else {
                                TextBox wageInput = new TextBox();
                                wageInput.setText(String.valueOf(wageList.get(0).getWage()));
                                editSearchedWagePanel
                                        .addComponent(new Label("Change wage of " + input.getText() + " :"))
                                        .addComponent(wageInput)
                                        .addComponent(new Button("Edit", ()->{
                                            wageList.get(0).setWage(Double.parseDouble(wageInput.getText()));
                                            wageController.updateWage(wageList.get(0));
                                            MessageDialog.showMessageDialog(textGUI,"Information", "Wage has been edited.", MessageDialogButton.OK);
                                            textGUI.removeWindow(editSearchedWageWindow);
                                            editSearchedWagePanel.removeAllComponents();
                                        }));
                                editSearchedWagePanel.addComponent(new Button("close", () -> textGUI.removeWindow(editSearchedWageWindow)));
                                textGUI.addWindowAndWait(editSearchedWageWindow);
                                editSearchedWagePanel.removeAllComponents();
                            }
                        }));
                editWagePanel.addComponent(new Button("close", () -> textGUI.removeWindow(editWageWindow)));
                textGUI.addWindowAndWait(editWageWindow);
                editWagePanel.removeAllComponents();
            }));


/***************************************REMOVING WAGE**************************************************************/


            Label removeWageLabel = new Label("Remove Wage");
            contentPanel.addComponent(removeWageLabel);

            contentPanel.addComponent(new Button("Remove Wage", () ->{
                TextBox input = new TextBox();
                removeWagePanel
                        .addComponent(new Label("Enter position:"))
                        .addComponent(input)
                        .addComponent(new Button("Remove", () -> {
                            List<Wage> wageList = wageController.searchWageByPosition(input.getText());
                            if(wageList.isEmpty()){
                                MessageDialog.showMessageDialog(textGUI, "Remove wage", "There is no wage for that position: " + input.getText() ,MessageDialogButton.OK);
                            }else if(employeeController.existEmployeeOnPosition(input.getText())){
                                MessageDialog.showMessageDialog(textGUI, "Remove wage", "Cannot remove wage! Exists employee on that position: " + input.getText() ,MessageDialogButton.OK);
                            }else {
                                removeWageCheckPanel
                                        .addComponent(new Label("Are You sure you want to remove position: '" + wageList.get(0).getPosition().toString() + "' permanently?"))
                                        .addComponent(new Button("Yes", ()->{
                                            wageController.deleteWage(wageList.get(0));
                                            MessageDialog.showMessageDialog(textGUI, "Remove wage", "Wage was successfully removed.", MessageDialogButton.OK);
                                            removeWageCheckPanel.removeAllComponents();
                                            textGUI.removeWindow(removeWageCheckWindow);
                                        }))
                                        .addComponent(new Button("No",()->{
                                            textGUI.removeWindow(removeWageCheckWindow);
                                            removeWageCheckPanel.removeAllComponents();
                                        }));
                                textGUI.addWindowAndWait(removeWageCheckWindow);
                                removeWageCheckPanel.removeAllComponents();
                            }
                        }))
                        .addComponent(new Button("Close", () -> textGUI.removeWindow(removeWageWindow)).setLayoutData(GridLayout.createHorizontallyEndAlignedLayoutData(2)));
                textGUI.addWindowAndWait(removeWageWindow);
                removeWagePanel.removeAllComponents();
            }));


            contentPanel.addComponent(
                    new Button("Close", window::close).setLayoutData(
                            GridLayout.createHorizontallyEndAlignedLayoutData(2)));


            addCarWindow.setComponent(addCarPanel);
            searchCarByIdWindow.setComponent(searchCarByIdPanel);
            searchCarByModelWindow.setComponent(searchCarByModelPanel);
            searchCarByVINWindow.setComponent(searchCarByVINPanel);
            searchCarByBrandWindow.setComponent(searchCarByBrandPanel);
            printAllCarsWindow.setComponent(printAllCarsPanel);
            removeCarWindow.setComponent(removeCarPanel);
            removeCarCheckWindow.setComponent(removeCarCheckPanel);
            searchPersonWindow.setComponent(searchPersonPanel);
            addPersonWindow.setComponent(addPersonPanel);
            removePersonWindow.setComponent(removePersonPanel);
            removePersonCheckWindow.setComponent(removePersonCheckPanel);
            searchRentByIdWindow.setComponent(searchRentByIdPanel);
            addRentWindow.setComponent(addRentPanel);
            removeRentWindow.setComponent(removeRentPanel);
            removeRentCheckWindow.setComponent(removeRentCheckPanel);
            addClientWindow.setComponent(addClientPanel);
            removeClientWindow.setComponent(removeClientPanel);
            removeClientCheckWindow.setComponent(removeClientCheckPanel);
            searchCarToRemoveWindow.setComponent(searchCarToRemovePanel);
            searchRentToRemoveWindow.setComponent(searchRentToRemovePanel);
            editCarWindow.setComponent(editCarPanel);
            editSearchedCarWindow.setComponent(editSearchedCarPanel);
            editPersonWindow.setComponent(editPersonPanel);
            editSearchedPersonWindow.setComponent(editSearchedPersonPanel);
            searchEmployeeByIdWindow.setComponent(searchEmployeeByIdPanel);
            addEmployeeWindow.setComponent(addEmployeePanel);
            editEmployeeWindow.setComponent(editEmployeePanel);
            editSearchedEmployeeWindow.setComponent(editSearchedEmployeePanel);
            removeEmployeeWindow.setComponent(removeEmployeePanel);
            removeEmployeeCheckWindow.setComponent(removeEmployeeCheckPanel);
            addReservationWindow.setComponent(addReservationPanel);
            removeReservationWindow.setComponent(removeReservationPanel);
            removeReservationCheckWindow.setComponent(removeReservationCheckPanel);
            searchReservationToRemoveWindow.setComponent(searchReservationToRemovePanel);
            addInsuranceWindow.setComponent(addInsurancePanel);
            removeInsuranceWindow.setComponent(removeInsurancePanel);
            removeInsuranceCheckWindow.setComponent(removeInsuranceCheckPanel);
            addWageWindow.setComponent(addWagePanel);
            editWageWindow.setComponent(editWagePanel);
            editSearchedWageWindow.setComponent(editSearchedWagePanel);
            removeWageWindow.setComponent(removeWagePanel);
            removeWageCheckWindow.setComponent(removeWageCheckPanel);
            addVehicleInspectionWindow.setComponent(addVehicleInspectionPanel);
            removeVehicleInspectionWindow.setComponent(removeVehicleInspectionPanel);
            removeVehicleInspectionCheckWindow.setComponent(removeVehicleInspectionCheckPanel);
            addFaultWindow.setComponent(addFaultPanel);
            editFaultWindow.setComponent(editFaultPanel);
            editSearchedFaultWindow.setComponent(editSearchedFaultPanel);
            removeFaultWindow.setComponent(removeFaultPanel);
            removeFaultCheckWindow.setComponent(removeFaultCheckPanel);
            checkReservationWindow.setComponent(checkReservationPanel);
            checkReservationByPeselWindow.setComponent(checkReservationByPeselPanel);
            chooseReservationToExecuteWindow.setComponent(chooseReservationToExecutePanel);
            changeReservationToRentWindow.setComponent(changeReservationToRentPanel);


            window.setComponent(contentPanel);
            textGUI.addWindowAndWait(window);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(screen != null) {
                try {
                    screen.stopScreen();
                }
                catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
