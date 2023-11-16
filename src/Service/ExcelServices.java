/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import DomainModel.ChucVu;
import ViewModel.ThongKeViewModel;
import java.util.List;

/**
 *
 * @author haha
 */
public interface ExcelServices {

    List<String> getFile(String link);

   void xuatExecl( List<ThongKeViewModel> tkk, String file);

    String barCode(String nhap, String link);

    String barCodeIMEI(String link);
}
