/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author haha
 */
public class ThongSoViewModel {

    private String boNhoID;
    private String ram;
    private String rom;
    private String theNho;

    private String CPUID;
    private String CPU;
    private String GPU;
    private String CPULoai;
    private String CPUHang;
    private String tienTrinh;

    private String pinID;
    private String pinDungLuong;
    private String pinLoai;
    private String sac;
    private String pindacBiet;

    private String HDHID;
    private String heDieuhanh;
    private String HDHphienBan;

    private String thietKeID;
    private String matTruoc;
    private String matLung;
    private String khungVien;
    private String trongLuong;

    private String manHinhID;
    private String manHinhLoai;
    private String manHinhKieu;
    private String tangSoQuet;
    private String doPhanGiai;
    private String manHinhKichThuoc;
    private String manHinhCongNghe;

    private String ketNoiID;
    private String SIM;
    private String hongNgoai;
    private String jackTaiNghe;
    private String mangHoTro;
    private String wifi;
    private String blutooth;
    private String GPS;

    private String mauSacID;
    private String mauTen;
    private String mauMa;

    private String tienIchID;
    private String baoMat;
    private String khangNuoc;
    private String dacBiet;

    private String cameraID;
    private String cameraTruoc;
    private String cameraSau;
    private String quayVideo;
    private String Zoom;
    private String chongRung;
    private String CameraDacBiet;

    public ThongSoViewModel() {
    }

    public ThongSoViewModel(String boNhoID, String ram, String rom, String theNho, String CPUID, String CPU, String GPU, String CPULoai, String CPUHang, String tienTrinh, String pinID, String pinDungLuong, String pinLoai, String sac, String pindacBiet, String HDHID, String heDieuhanh, String HDHphienBan, String thietKeID, String matTruoc, String matLung, String khungVien, String trongLuong, String manHinhID, String manHinhLoai, String manHinhKieu, String tangSoQuet, String doPhanGiai, String manHinhKichThuoc, String manHinhCongNghe, String ketNoiID, String SIM, String hongNgoai, String jackTaiNghe, String mangHoTro, String wifi, String blutooth, String GPS, String mauSacID, String mauTen, String mauMa, String tienIchID, String baoMat, String khangNuoc, String dacBiet, String cameraID, String cameraTruoc, String cameraSau, String quayVideo, String Zoom, String chongRung, String CameraDacBiet) {
        this.boNhoID = boNhoID;
        this.ram = ram;
        this.rom = rom;
        this.theNho = theNho;
        this.CPUID = CPUID;
        this.CPU = CPU;
        this.GPU = GPU;
        this.CPULoai = CPULoai;
        this.CPUHang = CPUHang;
        this.tienTrinh = tienTrinh;
        this.pinID = pinID;
        this.pinDungLuong = pinDungLuong;
        this.pinLoai = pinLoai;
        this.sac = sac;
        this.pindacBiet = pindacBiet;
        this.HDHID = HDHID;
        this.heDieuhanh = heDieuhanh;
        this.HDHphienBan = HDHphienBan;
        this.thietKeID = thietKeID;
        this.matTruoc = matTruoc;
        this.matLung = matLung;
        this.khungVien = khungVien;
        this.trongLuong = trongLuong;
        this.manHinhID = manHinhID;
        this.manHinhLoai = manHinhLoai;
        this.manHinhKieu = manHinhKieu;
        this.tangSoQuet = tangSoQuet;
        this.doPhanGiai = doPhanGiai;
        this.manHinhKichThuoc = manHinhKichThuoc;
        this.manHinhCongNghe = manHinhCongNghe;
        this.ketNoiID = ketNoiID;
        this.SIM = SIM;
        this.hongNgoai = hongNgoai;
        this.jackTaiNghe = jackTaiNghe;
        this.mangHoTro = mangHoTro;
        this.wifi = wifi;
        this.blutooth = blutooth;
        this.GPS = GPS;
        this.mauSacID = mauSacID;
        this.mauTen = mauTen;
        this.mauMa = mauMa;
        this.tienIchID = tienIchID;
        this.baoMat = baoMat;
        this.khangNuoc = khangNuoc;
        this.dacBiet = dacBiet;
        this.cameraID = cameraID;
        this.cameraTruoc = cameraTruoc;
        this.cameraSau = cameraSau;
        this.quayVideo = quayVideo;
        this.Zoom = Zoom;
        this.chongRung = chongRung;
        this.CameraDacBiet = CameraDacBiet;
    }
    

    public String getBoNhoID() {
        return boNhoID;
    }

    public void setBoNhoID(String boNhoID) {
        this.boNhoID = boNhoID;
    }

    public String getCPUID() {
        return CPUID;
    }

    public void setCPUID(String CPUID) {
        this.CPUID = CPUID;
    }

    public String getPinID() {
        return pinID;
    }

    public void setPinID(String pinID) {
        this.pinID = pinID;
    }

    public String getHDHID() {
        return HDHID;
    }

    public void setHDHID(String HDHID) {
        this.HDHID = HDHID;
    }

    public String getThietKeID() {
        return thietKeID;
    }

    public String getCameraID() {
        return cameraID;
    }

    public void setCameraID(String cameraID) {
        this.cameraID = cameraID;
    }

    public String getCameraTruoc() {
        return cameraTruoc;
    }

    public void setCameraTruoc(String cameraTruoc) {
        this.cameraTruoc = cameraTruoc;
    }

    public String getCameraSau() {
        return cameraSau;
    }

    public void setCameraSau(String cameraSau) {
        this.cameraSau = cameraSau;
    }

    public String getQuayVideo() {
        return quayVideo;
    }

    public void setQuayVideo(String quayVideo) {
        this.quayVideo = quayVideo;
    }

    public String getZoom() {
        return Zoom;
    }

    public void setZoom(String Zoom) {
        this.Zoom = Zoom;
    }

    public String getChongRung() {
        return chongRung;
    }

    public void setChongRung(String chongRung) {
        this.chongRung = chongRung;
    }

    public String getCameraDacBiet() {
        return CameraDacBiet;
    }

    public void setCameraDacBiet(String CameraDacBiet) {
        this.CameraDacBiet = CameraDacBiet;
    }

    public void setThietKeID(String thietKeID) {
        this.thietKeID = thietKeID;
    }

    public String getManHinhID() {
        return manHinhID;
    }

    public void setManHinhID(String manHinhID) {
        this.manHinhID = manHinhID;
    }

    public String getKetNoiID() {
        return ketNoiID;
    }

    public void setKetNoiID(String ketNoiID) {
        this.ketNoiID = ketNoiID;
    }

    public String getMauSacID() {
        return mauSacID;
    }

    public void setMauSacID(String mauSacID) {
        this.mauSacID = mauSacID;
    }

    public String getTienIchID() {
        return tienIchID;
    }

    public void setTienIchID(String tienIchID) {
        this.tienIchID = tienIchID;
    }

    public ThongSoViewModel(String boNhoID, String ram, String rom, String theNho, String CPUID, String CPU, String GPU, String CPULoai, String CPUHang, String tienTrinh, String pinID, String pinDungLuong, String pinLoai, String sac, String pindacBiet, String HDHID, String heDieuhanh, String HDHphienBan, String thietKeID, String matTruoc, String matLung, String khungVien, String trongLuong, String manHinhID, String manHinhLoai, String manHinhKieu, String tangSoQuet, String doPhanGiai, String manHinhKichThuoc, String manHinhCongNghe, String ketNoiID, String SIM, String hongNgoai, String jackTaiNghe, String mangHoTro, String wifi, String blutooth, String GPS, String mauSacID, String mauMa, String mauTen, String tienIchID, String baoMat, String khangNuoc, String dacBiet) {
        this.boNhoID = boNhoID;
        this.ram = ram;
        this.rom = rom;
        this.theNho = theNho;
        this.CPUID = CPUID;
        this.CPU = CPU;
        this.GPU = GPU;
        this.CPULoai = CPULoai;
        this.CPUHang = CPUHang;
        this.tienTrinh = tienTrinh;
        this.pinID = pinID;
        this.pinDungLuong = pinDungLuong;
        this.pinLoai = pinLoai;
        this.sac = sac;
        this.pindacBiet = pindacBiet;
        this.HDHID = HDHID;
        this.heDieuhanh = heDieuhanh;
        this.HDHphienBan = HDHphienBan;
        this.thietKeID = thietKeID;
        this.matTruoc = matTruoc;
        this.matLung = matLung;
        this.khungVien = khungVien;
        this.trongLuong = trongLuong;
        this.manHinhID = manHinhID;
        this.manHinhLoai = manHinhLoai;
        this.manHinhKieu = manHinhKieu;
        this.tangSoQuet = tangSoQuet;
        this.doPhanGiai = doPhanGiai;
        this.manHinhKichThuoc = manHinhKichThuoc;
        this.manHinhCongNghe = manHinhCongNghe;
        this.ketNoiID = ketNoiID;
        this.SIM = SIM;
        this.hongNgoai = hongNgoai;
        this.jackTaiNghe = jackTaiNghe;
        this.mangHoTro = mangHoTro;
        this.wifi = wifi;
        this.blutooth = blutooth;
        this.GPS = GPS;
        this.mauSacID = mauSacID;
        this.mauTen = mauTen;
        this.mauMa = mauMa;
        this.tienIchID = tienIchID;
        this.baoMat = baoMat;
        this.khangNuoc = khangNuoc;
        this.dacBiet = dacBiet;
    }

    @Override
    public String toString() {
        return "ThongSoViewModel{" + "ram=" + ram + ", rom=" + rom + ", theNho=" + theNho + ", CPU=" + CPU + ", GPU=" + GPU + ", CPULoai=" + CPULoai + ", CPUHang=" + CPUHang + ", tienTrinh=" + tienTrinh + ", pinDungLuong=" + pinDungLuong + ", pinLoai=" + pinLoai + ", sac=" + sac + ", pindacBiet=" + pindacBiet + ", heDieuhanh=" + heDieuhanh + ", HDHphienBan=" + HDHphienBan + ", matTruoc=" + matTruoc + ", matLung=" + matLung + ", khungVien=" + khungVien + ", trongLuong=" + trongLuong + ", manHinhLoai=" + manHinhLoai + ", manHinhKieu=" + manHinhKieu + ", tangSoQuet=" + tangSoQuet + ", doPhanGiai=" + doPhanGiai + ", manHinhKichThuoc=" + manHinhKichThuoc + ", manHinhCongNghe=" + manHinhCongNghe + ", SIM=" + SIM + ", hongNgoai=" + hongNgoai + ", jackTaiNghe=" + jackTaiNghe + ", mangHoTro=" + mangHoTro + ", wifi=" + wifi + ", blutooth=" + blutooth + ", GPS=" + GPS + ", mauTen=" + mauTen + ", mauMa=" + mauMa + ", baoMat=" + baoMat + ", khangNuoc=" + khangNuoc + ", dacBiet=" + dacBiet + '}';
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getRom() {
        return rom;
    }

    public void setRom(String rom) {
        this.rom = rom;
    }

    public String getTheNho() {
        return theNho;
    }

    public void setTheNho(String theNho) {
        this.theNho = theNho;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getGPU() {
        return GPU;
    }

    public void setGPU(String GPU) {
        this.GPU = GPU;
    }

    public String getCPULoai() {
        return CPULoai;
    }

    public void setCPULoai(String CPULoai) {
        this.CPULoai = CPULoai;
    }

    public String getCPUHang() {
        return CPUHang;
    }

    public void setCPUHang(String CPUHang) {
        this.CPUHang = CPUHang;
    }

    public String getTienTrinh() {
        return tienTrinh;
    }

    public void setTienTrinh(String tienTrinh) {
        this.tienTrinh = tienTrinh;
    }

    public String getPinDungLuong() {
        return pinDungLuong;
    }

    public void setPinDungLuong(String pinDungLuong) {
        this.pinDungLuong = pinDungLuong;
    }

    public String getPinLoai() {
        return pinLoai;
    }

    public void setPinLoai(String pinLoai) {
        this.pinLoai = pinLoai;
    }

    public String getSac() {
        return sac;
    }

    public void setSac(String sac) {
        this.sac = sac;
    }

    public String getPindacBiet() {
        return pindacBiet;
    }

    public void setPindacBiet(String pindacBiet) {
        this.pindacBiet = pindacBiet;
    }

    public String getHeDieuhanh() {
        return heDieuhanh;
    }

    public void setHeDieuhanh(String heDieuhanh) {
        this.heDieuhanh = heDieuhanh;
    }

    public String getHDHphienBan() {
        return HDHphienBan;
    }

    public void setHDHphienBan(String HDHphienBan) {
        this.HDHphienBan = HDHphienBan;
    }

    public String getMatTruoc() {
        return matTruoc;
    }

    public void setMatTruoc(String matTruoc) {
        this.matTruoc = matTruoc;
    }

    public String getMatLung() {
        return matLung;
    }

    public void setMatLung(String matLung) {
        this.matLung = matLung;
    }

    public String getKhungVien() {
        return khungVien;
    }

    public void setKhungVien(String khungVien) {
        this.khungVien = khungVien;
    }

    public String getTrongLuong() {
        return trongLuong;
    }

    public void setTrongLuong(String trongLuong) {
        this.trongLuong = trongLuong;
    }

    public String getManHinhLoai() {
        return manHinhLoai;
    }

    public void setManHinhLoai(String manHinhLoai) {
        this.manHinhLoai = manHinhLoai;
    }

    public String getManHinhKieu() {
        return manHinhKieu;
    }

    public void setManHinhKieu(String manHinhKieu) {
        this.manHinhKieu = manHinhKieu;
    }

    public String getTangSoQuet() {
        return tangSoQuet;
    }

    public void setTangSoQuet(String tangSoQuet) {
        this.tangSoQuet = tangSoQuet;
    }

    public String getDoPhanGiai() {
        return doPhanGiai;
    }

    public void setDoPhanGiai(String doPhanGiai) {
        this.doPhanGiai = doPhanGiai;
    }

    public String getManHinhKichThuoc() {
        return manHinhKichThuoc;
    }

    public void setManHinhKichThuoc(String manHinhKichThuoc) {
        this.manHinhKichThuoc = manHinhKichThuoc;
    }

    public String getManHinhCongNghe() {
        return manHinhCongNghe;
    }

    public void setManHinhCongNghe(String manHinhCongNghe) {
        this.manHinhCongNghe = manHinhCongNghe;
    }

    public String getSIM() {
        return SIM;
    }

    public void setSIM(String SIM) {
        this.SIM = SIM;
    }

    public String getHongNgoai() {
        return hongNgoai;
    }

    public void setHongNgoai(String hongNgoai) {
        this.hongNgoai = hongNgoai;
    }

    public String getJackTaiNghe() {
        return jackTaiNghe;
    }

    public void setJackTaiNghe(String jackTaiNghe) {
        this.jackTaiNghe = jackTaiNghe;
    }

    public String getMangHoTro() {
        return mangHoTro;
    }

    public void setMangHoTro(String mangHoTro) {
        this.mangHoTro = mangHoTro;
    }

    public String getWifi() {
        return wifi;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi;
    }

    public String getBlutooth() {
        return blutooth;
    }

    public void setBlutooth(String blutooth) {
        this.blutooth = blutooth;
    }

    public String getGPS() {
        return GPS;
    }

    public void setGPS(String GPS) {
        this.GPS = GPS;
    }

    public String getMauTen() {
        return mauTen;
    }

    public void setMauTen(String mauTen) {
        this.mauTen = mauTen;
    }

    public String getMauMa() {
        return mauMa;
    }

    public void setMauMa(String mauMa) {
        this.mauMa = mauMa;
    }

    public String getBaoMat() {
        return baoMat;
    }

    public void setBaoMat(String baoMat) {
        this.baoMat = baoMat;
    }

    public String getKhangNuoc() {
        return khangNuoc;
    }

    public void setKhangNuoc(String khangNuoc) {
        this.khangNuoc = khangNuoc;
    }

    public String getDacBiet() {
        return dacBiet;
    }

    public void setDacBiet(String dacBiet) {
        this.dacBiet = dacBiet;
    }

}
