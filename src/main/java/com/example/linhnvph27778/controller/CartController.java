package com.example.linhnvph27778.controller;

import com.example.linhnvph27778.model.Cart;
import com.example.linhnvph27778.model.ChiTietSanPham;
import com.example.linhnvph27778.model.HoaDon;
import com.example.linhnvph27778.model.HoaDonChiTiet;
import com.example.linhnvph27778.model.IdHoaDonChiTiet;
import com.example.linhnvph27778.model.Item;
import com.example.linhnvph27778.service.ChiTietSPService;
import com.example.linhnvph27778.service.HoaDonChiTietService;
import com.example.linhnvph27778.service.HoaDonService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/mua-hang")
public class CartController {
    @Autowired
    private ChiTietSPService chiTietSPService;

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private HoaDonService hoaDonService;

    @Autowired
    private HoaDonChiTietService hoaDonChiTietService;

    @Autowired
    private HttpSession session;



    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @GetMapping("/hien-thi")
    public String getData(Model model){
        model.addAttribute("list",chiTietSPService.getAll());
        model.addAttribute("view","/views/banhang/chitietsanpham.jsp");
        return "banhang/layout";
    }


    @GetMapping("/cart/add")
    public String addToCart(@RequestParam("ctspId") UUID ctspId) {
        // lấy ctsp từ repo
        Optional<ChiTietSanPham> chiTietSanPham = chiTietSPService.getById(ctspId);

        // tạo ra giỏ hàng chi tiết
        Item item = new Item(chiTietSanPham.get().getId(),
                chiTietSanPham.get().getSanPham().getTen(),
                chiTietSanPham.get().getMauSac().getTen(),
                chiTietSanPham.get().getNhaSanXuat().getTen(),
                chiTietSanPham.get().getDongSanPham().getTen(),
                1,
                chiTietSanPham.get().getGiaBan());
        //lấy gior hàng từ session
        Cart cartSesion = (Cart) httpSession.getAttribute("cart");
        // nếu chưa có giỏ hàng
        if (cartSesion == null) {
            Cart cart = new Cart();
            ArrayList<Item> list = new ArrayList<>();
            list.add(item);
            cart.setListItem(list);
            httpSession.setAttribute("cart", cart);
        } else {
            // nếu có giỏ hàng
            Cart cart = (Cart) httpSession.getAttribute("cart");
            ArrayList<Item> listItem = cart.getListItem();
            // kieemr tra sản phẩm đã có trong giỏ hàng chưa
            // nếu có thì tăng số lwonjg lên 1
            for (Item itemTmp : listItem) {
                if (itemTmp.getIdCtsp().equals(ctspId)) {
                    itemTmp.setSoLuong(itemTmp.getSoLuong() + 1);
                    return "redirect:/mua-hang/cart/view";
                }
            }
            // không có thì thêm sản phẩm vào
            listItem.add(item);
        }
        // tạo giỏ hàng trong db
//        String ma = String.valueOf(Math.floor(((Math.random() * 899999) + 100000)));
//        Date ngayTao= new Date();
//        int tinhTrang = 1;
//        GioHang gioHang = new GioHang();
//        gioHang.setMa(ma);
//        gioHang.setNgayTao(ngayTao);
//        gioHang.setTinhTrang(tinhTrang);

        return "redirect:/mua-hang/cart/view";

    }


    @GetMapping("/cart/view")
    public String addToCart(Model model) {
        Cart cart = (Cart) httpSession.getAttribute("cart");
        ArrayList<Item> list = cart.getListItem();
        if (cart == null ){
//            model.addAttribute("mesNull", "Bnaj chưa có sản phẩm trong giỏ hàng");
            session.setAttribute("error","Bạn chưa có sp trong giỏ");
            model.addAttribute("view","/views/banhang/chitietsanpham.jsp");
            return "banhang/layout";
        }else {
            model.addAttribute("gioHangChiTiet", list);
            session.setAttribute("message","Thêm vào giỏ hàng thành công");
            model.addAttribute("view","/views/banhang/giohang.jsp");
            return "banhang/layout";
        }
    }

    @GetMapping("/mua-mot-sp")
    public String muaHang(@RequestParam("ctspId") UUID idCtsp,Model model){

        //tạo hóa đơn
        String ma = String.valueOf(Math.floor(((Math.random() * 899999) + 100000)));
        Date ngayTao= new Date();
        int tinhTrang = 1;
        HoaDon hd = new HoaDon();
        hd.setMa(ma);
        hd.setNgayTao(ngayTao);
        hd.setTinhTrang(tinhTrang);
        hoaDonService.add(hd);

        // thêm vào hóa đơn chi tiết
        Cart cart = (Cart) httpSession.getAttribute("cart");
        ArrayList<Item> list = cart.getListItem();
        int soLuong = 0;
        double donGia =0;
        int dem=0;
        for (Item item : list) {
            if (item.getIdCtsp().equals(idCtsp)) {
                soLuong = item.getSoLuong();
                donGia = item.getGiaBan();
                break;
            }
            dem++;
        }
        HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();

        IdHoaDonChiTiet idHoaDonChiTiet = new IdHoaDonChiTiet();
        idHoaDonChiTiet.setIdHoaDon(hd.getId());
        idHoaDonChiTiet.setIdChiTietSP(idCtsp);

        hoaDonChiTiet.setIdChiTietSP(idHoaDonChiTiet.getIdChiTietSP());
        hoaDonChiTiet.setIdHoaDon(idHoaDonChiTiet.getIdHoaDon());
        hoaDonChiTiet.setSoLuong(soLuong);
        hoaDonChiTiet.setDonGia(donGia);
        hoaDonChiTietService.add(hoaDonChiTiet);

        // xóa giỏ hàng
        list.remove(dem);
        // update so luong
        ChiTietSanPham chiTietSanPham = chiTietSPService.getOne(idCtsp);
        chiTietSanPham.setSoLuongTon(chiTietSanPham.getSoLuongTon()-soLuong);
        chiTietSPService.saveOrUpdate(chiTietSanPham);
        System.out.println(chiTietSanPham.getSoLuongTon());

       // model.addAttribute("view","/views/banhang/giohang.jsp");
        session.setAttribute("message","Mua thành công một sản phẩm");
        return "redirect:/mua-hang/cart/view";
      //  return "banhang/layout";
    }

    @GetMapping("/mua-tat-ca")
    public String muaHangTatCa(Model model){
        Cart cart = (Cart) httpSession.getAttribute("cart");
        ArrayList<Item> list = cart.getListItem();

        // tạo hóa đơn
        String ma = String.valueOf(Math.floor(((Math.random() * 899999) + 100000)));
        Date ngayTao = new Date();
        int tinhTrang = 1;
        HoaDon hd = new HoaDon();
        hd.setMa(ma);
        hd.setNgayTao(ngayTao);
        hd.setTinhTrang(tinhTrang);
        hoaDonService.add(hd);

        for (Item item : list) {
            UUID idCtsp = item.getIdCtsp();
            int soLuong = item.getSoLuong();
            double donGia = item.getGiaBan();

            HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
            hoaDonChiTiet.setIdChiTietSP(idCtsp);
            hoaDonChiTiet.setIdHoaDon(hd.getId());
            hoaDonChiTiet.setSoLuong(soLuong);
            hoaDonChiTiet.setDonGia(donGia);
            hoaDonChiTietService.add(hoaDonChiTiet);
            // update soLuong
            ChiTietSanPham chiTietSanPham = chiTietSPService.getOne(idCtsp);
            chiTietSanPham.setSoLuongTon(chiTietSanPham.getSoLuongTon()-soLuong);
            chiTietSPService.saveOrUpdate(chiTietSanPham);

            // Sau khi đã mua hàng thực hiện xóa giỏ hàng
            httpSession.removeAttribute("cart");
        }
        session.setAttribute("message","Mua hàng thành công");
        return "redirect:/mua-hang/hien-thi";

    }
}
