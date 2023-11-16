package Service;

import DomainModel.ChiTietDienThoai;
import DomainModel.QuocGiaDong;
import DomainModel.ThongSo;
import ViewModel.ThongSoViewModel;
import ViewModel.vts;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
/**
 *
 * @author haha
 */
public interface AddElementServices {

    List<vts> view(ThongSoViewModel t);

    String themThongSo(ThongSo t);

    String suaThongSo(ThongSo t);

    String giaTien1(ChiTietDienThoai t);

    String giaTien2(QuocGiaDong t);

    String xoaQG(String id, int tt);

    String xoaCTDT(String id);

    String themQuocGiaDong(QuocGiaDong qgd);

    List<QuocGiaDong> getf(String x);

    String idQGD(QuocGiaDong qgd);

}
