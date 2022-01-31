package Chapter_09;

import java.io.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class k27_Biz_09_02_StockInsert {
    public static class JDBC {
        private static int batchNum = 0;
        private static Connection conn;

        // Connection 클래스 형 conn 객체에 대한 싱클톤 패턴(Singleton pattern)을 적용하여 접속이 유지된 상태면 다시 접속을 하지 않고
        // 접속이 이뤄지지 않은 상태(객체 생성전)면 conn 객체에 DriverManger.getConnection으로 접속한다.
        // Connection 메소드를 각 쿼리 도입부에 삽입하고 쿼리를 재실행하여도 접속이 유지되도록 한다.
        public static synchronized Connection getInstance() {
            // static 변수 conn의 상태를 확인하고
            // null(접속 해제 상태)이면 접속을 진행한다
            // null이 아니면(접속 상태) 이 구문을 지나친다. (접속 유지)
            if (conn == null) {
                final String id = "test2";
                final String password = "in6612";
                final String url = "jdbc:mysql://192.168.1.173:33060/biz_programing?rewriteBatchedStatements=true&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&allowPublicKeyRetrieval=true&useSSL=false";
                try {
                    conn = DriverManager.getConnection(url, id, password);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            // 접속 정보가 담긴 인스턴스 conn을 리턴한다.
            return conn;
        }

        public static int insertStockList(ArrayList<String[]> fieldList) throws SQLException {
            Connection conn = getInstance();
            PreparedStatement pstmt = null;
            String sql = "INSERT ignore INTO stock(stnd_iscd, bsop_date, shrn_iscd, stck_prpr, stck_oprc, stck_hgpr, stck_lwpr, prdy_vrss_sign, prdy_vrss, prdy_ctrt, prdy_vol, acml_vol, acml_tr_pbmn, askp1, bidp1, total_askp_rsqn, total_bidp_rsqn, seln_cntg_smtn, shnu_cntg_smtn, seln_tr_pbmn, shnu_tr_pbmn, seln_cntg_csnu, shnu_cntg_csnu, w52_hgpr, w52_lwpr, w52_hgpr_date, w52_lwpr_date, ovtm_untp_bsop_hour, ovtm_untp_prpr, ovtm_untp_prdy_vrss, ovtm_untp_prdy_vrss_sign, ovtm_untp_askp1, ovtm_untp_bidp1, ovtm_untp_vol, ovtm_untp_tr_pbmn, ovtm_untp_oprc, ovtm_untp_hgpr, ovtm_untp_lwpr, mkob_otcp_vol, mkob_otcp_tr_pbmn, mkfa_otcp_vol, mkfa_otcp_tr_pbmn, mrkt_div_cls_code, pstc_dvdn_amt, lstn_stcn, stck_sdpr, stck_fcam, wghn_avrg_stck_prc, issu_limt_rate, frgn_limt_qty, oder_able_qty, frgn_limt_exhs_cls_code, frgn_hldn_qty, frgn_hldn_rate, hts_frgn_ehrt, itmt_last_nav, prdy_last_nav, trc_errt, dprt, ssts_cntg_qty, ssts_tr_pbmn, frgn_ntby_qty, flng_cls_code, prtt_rate, acml_prtt_rate, stdv, beta_cfcn, crlt_cfcn, bull_beta, bear_beta, bull_dvtn, bear_dvtn, bull_crlt, bear_crlt, stck_mxpr, stck_llam, icic_cls_code, itmt_vol, itmt_tr_pbmn, fcam_mod_cls_code, revl_issu_reas_code, orgn_ntby_qty, adj_prpr, fn_oprc, fn_hgpr, fn_lwpr, fn_prpr, fn_acml_vol, fn_acml_tr_pbmn, fn_prtt_rate, fn_flng_cls_code, buyin_nor_prpr, buyin_nor_prdy_vrss, buyin_nor_vol, buyin_nor_tr_pbmn, buyin_tod_prpr, buyin_tod_prdy_vrss, buyin_tod_vol, buyin_tod_tr_pbmn) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?)";

            //String sql = "INSERT IGNORE INTO stock(stnd_iscd, bsop_date, shrn_iscd, stck_prpr, stck_oprc, stck_hgpr, stck_lwpr, prdy_vrss_sign, prdy_vrss, prdy_ctrt, prdy_vol) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            SimpleDateFormat sdfYMD = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            conn.setAutoCommit(false);
            //String[] rField = fieldList.get(0);
            //System.out.println(rField[0]);
            //System.out.println(fieldList.get(0));

            //int batchNum = 0;
            String[] refineField;
            try {
                pstmt = conn.prepareStatement(sql);
                for (int i = 0; i < fieldList.size(); i++) {
                    refineField = fieldList.get(i);
                    pstmt.setString(1, refineField[0]);
                    pstmt.setInt(2, Integer.parseInt(refineField[1]));
                    pstmt.setString(3, refineField[2]);
                    pstmt.setInt(4, Integer.parseInt(refineField[3]));
                    pstmt.setInt(5, Integer.parseInt(refineField[4]));
                    pstmt.setInt(6, Integer.parseInt(refineField[5]));
                    pstmt.setInt(7, Integer.parseInt(refineField[6]));
                    pstmt.setString(8, refineField[7]);
                    pstmt.setInt(9, Integer.parseInt(refineField[8]));
                    pstmt.setFloat(10, Float.parseFloat(refineField[9]));
                    pstmt.setLong(11, Long.parseLong(refineField[10]));
                    pstmt.setLong(12, Long.parseLong(refineField[11]));
                    pstmt.setLong(13, Long.parseLong(refineField[12]));
                    pstmt.setInt(14, Integer.parseInt(refineField[13]));
                    pstmt.setInt(15, Integer.parseInt(refineField[14]));
                    pstmt.setLong(16, Long.parseLong(refineField[15]));
                    pstmt.setLong(17, Long.parseLong(refineField[16]));
                    pstmt.setLong(18, Long.parseLong(refineField[17]));
                    pstmt.setLong(19, Long.parseLong(refineField[18]));
                    pstmt.setLong(20, Long.parseLong(refineField[19]));
                    pstmt.setLong(21, Long.parseLong(refineField[20]));
                    pstmt.setInt(22, Integer.parseInt(refineField[21]));
                    pstmt.setInt(23, Integer.parseInt(refineField[22]));
                    pstmt.setInt(24, Integer.parseInt(refineField[23]));
                    pstmt.setInt(25, Integer.parseInt(refineField[24]));
                    pstmt.setInt(26, Integer.parseInt(refineField[25]));
                    pstmt.setInt(27, Integer.parseInt(refineField[26]));
                    pstmt.setInt(28, Integer.parseInt(refineField[27]));
                    pstmt.setInt(29, Integer.parseInt(refineField[28]));
                    pstmt.setInt(30, Integer.parseInt(refineField[29]));
                    pstmt.setString(31, refineField[30]);
                    pstmt.setInt(32, Integer.parseInt(refineField[31]));
                    pstmt.setInt(33, Integer.parseInt(refineField[32]));
                    pstmt.setLong(34, Long.parseLong(refineField[33]));
                    pstmt.setLong(35, Long.parseLong(refineField[34]));
                    pstmt.setInt(36, Integer.parseInt(refineField[35]));
                    pstmt.setInt(37, Integer.parseInt(refineField[36]));
                    pstmt.setInt(38, Integer.parseInt(refineField[37]));
                    pstmt.setLong(39, Long.parseLong(refineField[38]));
                    pstmt.setLong(40, Long.parseLong(refineField[39]));
                    pstmt.setLong(41, Long.parseLong(refineField[40]));
                    pstmt.setLong(42, Long.parseLong(refineField[41]));
                    pstmt.setString(43, refineField[42]);
                    pstmt.setLong(44, Long.parseLong(refineField[43]));
                    pstmt.setLong(45, Long.parseLong(refineField[44]));
                    pstmt.setInt(46, Integer.parseInt(refineField[45]));
                    pstmt.setFloat(47, Float.parseFloat(refineField[46]));
                    pstmt.setFloat(48, Float.parseFloat(refineField[47]));
                    pstmt.setFloat(49, Float.parseFloat(refineField[48]));
                    pstmt.setLong(50, Long.parseLong(refineField[49]));
                    pstmt.setLong(51, Long.parseLong(refineField[50]));
                    pstmt.setString(52, refineField[51]);
                    pstmt.setLong(53, Long.parseLong(refineField[52]));
                    pstmt.setFloat(54, Float.parseFloat(refineField[53]));
                    pstmt.setFloat(55, Float.parseFloat(refineField[54]));
                    pstmt.setFloat(56, Float.parseFloat(refineField[55]));
                    pstmt.setFloat(57, Float.parseFloat(refineField[56]));
                    pstmt.setFloat(58, Float.parseFloat(refineField[57]));
                    pstmt.setFloat(59, Float.parseFloat(refineField[58]));
                    pstmt.setLong(60, Long.parseLong(refineField[59]));
                    pstmt.setLong(61, Long.parseLong(refineField[60]));
                    pstmt.setLong(62, Long.parseLong(refineField[61]));
                    pstmt.setString(63, refineField[62]);
                    pstmt.setFloat(64, Float.parseFloat(refineField[63]));
                    pstmt.setFloat(65, Float.parseFloat(refineField[64]));
                    pstmt.setFloat(66, Float.parseFloat(refineField[65]));
                    pstmt.setFloat(67, Float.parseFloat(refineField[66]));
                    pstmt.setFloat(68, Float.parseFloat(refineField[67]));
                    pstmt.setFloat(69, Float.parseFloat(refineField[68]));
                    pstmt.setFloat(70, Float.parseFloat(refineField[69]));
                    pstmt.setFloat(71, Float.parseFloat(refineField[70]));
                    pstmt.setFloat(72, Float.parseFloat(refineField[71]));
                    pstmt.setFloat(73, Float.parseFloat(refineField[72]));
                    pstmt.setFloat(74, Float.parseFloat(refineField[73]));
                    pstmt.setInt(75, Integer.parseInt(refineField[74]));
                    pstmt.setInt(76, Integer.parseInt(refineField[75]));
                    pstmt.setString(77, refineField[76]);
                    pstmt.setLong(78, Long.parseLong(refineField[77]));
                    pstmt.setLong(79, Long.parseLong(refineField[78]));
                    pstmt.setString(80, refineField[79]);
                    pstmt.setString(81, refineField[80]);
                    pstmt.setLong(82, Long.parseLong(refineField[81]));
                    pstmt.setInt(83, Integer.parseInt(refineField[82]));
                    pstmt.setInt(84, Integer.parseInt(refineField[83]));
                    pstmt.setInt(85, Integer.parseInt(refineField[84]));
                    pstmt.setInt(86, Integer.parseInt(refineField[85]));
                    pstmt.setInt(87, Integer.parseInt(refineField[86]));
                    pstmt.setLong(88, Long.parseLong(refineField[87]));
                    pstmt.setLong(89, Long.parseLong(refineField[88]));
                    pstmt.setFloat(90, Float.parseFloat(refineField[89]));
                    pstmt.setString(91, refineField[90]);
                    pstmt.setInt(92, Integer.parseInt(refineField[91]));
                    pstmt.setInt(93, Integer.parseInt(refineField[92]));
                    pstmt.setLong(94, Long.parseLong(refineField[93]));
                    pstmt.setLong(95, Long.parseLong(refineField[94]));
                    pstmt.setInt(96, Integer.parseInt(refineField[95]));
                    pstmt.setInt(97, Integer.parseInt(refineField[96]));
                    pstmt.setLong(98, Long.parseLong(refineField[97]));
                    pstmt.setLong(99, Long.parseLong(refineField[98]));
                    pstmt.addBatch();
                    batchNum++;
                    if ((batchNum % 100) == 0) {
                        Calendar startTime = Calendar.getInstance();
                        System.out.printf("Batch Cycle: %d\n", batchNum);
                        System.out.println(sdfYMD.format(startTime.getTime()));
                        pstmt.executeBatch();
                        pstmt.clearBatch();
                        conn.commit();
                    }
                }
                pstmt.executeBatch();
                conn.commit();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return batchNum;
        }
    }

    public static void main(String[] args) throws IOException, ParseException, SQLException {
        SimpleDateFormat sdfYMD = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdfMS = new SimpleDateFormat("SSS");
        SimpleDateFormat sdfHMS = new SimpleDateFormat("HH:mm:ss");

        //File f = new File("THTSKS010H00.dat");
        File f = new File("StockTest.dat");
        BufferedReader br = new BufferedReader(new FileReader(f));

        String readtxt;

        int cnt = 0;
        int wcnt = 0;

        Calendar startTime = Calendar.getInstance();
        System.out.printf("Program Start\n");
        System.out.println(sdfYMD.format(startTime.getTime()));
        System.out.printf("\n");

        ArrayList<String[]> fieldList = new ArrayList<>();
        String[] refineField = new String[99];
        while ((readtxt = br.readLine()) != null) {
            StringBuffer s = new StringBuffer();
            String[] field = readtxt.split("%_%");

            if (field.length > 2 && field[2].replace("^", "").trim().substring(0, 1).equals("A")) {
                s.append(field[0].replace("^", "").trim());
                for (int j = 1; j < field.length; j++) {
                    s.append("," + field[j].replace("^", "").trim());
                }
                String[] splitField = s.toString().split(",");

                //Arrays.fill(refineField, "0");

                for (int i = 0; i < refineField.length; i++) {
                    if (i < splitField.length) {
                        if (splitField[i].matches("")) {
                            refineField[i] = "0";
                        } else {
                            refineField[i] = splitField[i];
                        }
                    } else {
                        if (refineField[i] == null) {
                            refineField[i] = "0";
                        }
                    }
                }
            }
            fieldList.add(refineField);

            cnt++;
            if (cnt % 100 == 0) {
                wcnt = JDBC.insertStockList(fieldList);
                fieldList.clear();
            }
        }

        br.close();

        System.out.printf("\nProgram End [%d] [%d] records\n", cnt, wcnt);
        Calendar endTime = Calendar.getInstance();
        System.out.println(sdfYMD.format(endTime.getTime()));
        System.out.printf("\n");

        long time = endTime.getTimeInMillis() - startTime.getTimeInMillis();
        Date procTime = sdfMS.parse(String.valueOf(time));

        System.out.printf("Processing Time: %s\n", sdfHMS.format(procTime));
    }

    public static class Stock {
        private String stnd_iscd;
        private int bsop_date;
        private String shrn_iscd;
        private int stck_prpr;
        private int stck_oprc;
        private int stck_hgpr;
        private int stck_lwpr;
        private String prdy_vrss_sign;
        private int prdy_vrss;
        private float prdy_ctrt;
        private long prdy_vol;
        private long acml_vol;
        private long acml_tr_pbmn;
        private int askp1;
        private int bidp1;
        private long total_askp_rsqn;
        private long total_bidp_rsqn;
        private long seln_cntg_smtn;
        private long shnu_cntg_smtn;
        private long seln_tr_pbmn;
        private long shnu_tr_pbmn;
        private int seln_cntg_csnu;
        private int shnu_cntg_csnu;
        private int w52_hgpr;
        private int w52_lwpr;
        private int w52_hgpr_date;
        private int w52_lwpr_date;
        private int ovtm_untp_bsop_hour;
        private int ovtm_untp_prpr;
        private int ovtm_untp_prdy_vrss;
        private String ovtm_untp_prdy_vrss_sign;
        private int ovtm_untp_askp1;
        private int ovtm_untp_bidp1;
        private long ovtm_untp_vol;
        private long ovtm_untp_tr_pbmn;
        private int ovtm_untp_oprc;
        private int ovtm_untp_hgpr;
        private int ovtm_untp_lwpr;
        private long mkob_otcp_vol;
        private long mkob_otcp_tr_pbmn;
        private long mkfa_otcp_vol;
        private long mkfa_otcp_tr_pbmn;
        private String mrkt_div_cls_code;
        private long pstc_dvdn_amt;
        private long lstn_stcn;
        private int stck_sdpr;
        private float stck_fcam;
        private float wghn_avrg_stck_prc;
        private float issu_limt_rate;
        private long frgn_limt_qty;
        private long oder_able_qty;
        private String frgn_limt_exhs_cls_code;
        private long frgn_hldn_qty;
        private float frgn_hldn_rate;
        private float hts_frgn_ehrt;
        private float itmt_last_nav;
        private float prdy_last_nav;
        private float trc_errt;
        private float dprt;
        private long ssts_cntg_qty;
        private long ssts_tr_pbmn;
        private long frgn_ntby_qty;
        private String flng_cls_code;
        private float prtt_rate;
        private float acml_prtt_rate;
        private float stdv;
        private float beta_cfcn;
        private float crlt_cfcn;
        private float bull_beta;
        private float bear_beta;
        private float bull_dvtn;
        private float bear_dvtn;
        private float bull_crlt;
        private float bear_crlt;
        private int stck_mxpr;
        private int stck_llam;
        private String icic_cls_code;
        private long itmt_vol;
        private long itmt_tr_pbmn;
        private String fcam_mod_cls_code;
        private String revl_issu_reas_code;
        private long orgn_ntby_qty;
        private int adj_prpr;
        private int fn_oprc;
        private int fn_hgpr;
        private int fn_lwpr;
        private int fn_prpr;
        private long fn_acml_vol;
        private long fn_acml_tr_pbmn;
        private float fn_prtt_rate;
        private String fn_flng_cls_code;
        private int buyin_nor_prpr;
        private int buyin_nor_prdy_vrss;
        private long buyin_nor_vol;
        private long buyin_nor_tr_pbmn;
        private int buyin_tod_prpr;
        private int buyin_tod_prdy_vrss;
        private long buyin_tod_vol;
        private long buyin_tod_tr_pbmn;

        public Stock(String stnd_iscd, int bsop_date, String shrn_iscd, int stck_prpr, int stck_oprc, int stck_hgpr, int stck_lwpr, String prdy_vrss_sign, int prdy_vrss, float prdy_ctrt, long prdy_vol, long acml_vol, long acml_tr_pbmn, int askp1, int bidp1, long total_askp_rsqn, long total_bidp_rsqn, long seln_cntg_smtn, long shnu_cntg_smtn, long seln_tr_pbmn, long shnu_tr_pbmn, int seln_cntg_csnu, int shnu_cntg_csnu, int w52_hgpr, int w52_lwpr, int w52_hgpr_date, int w52_lwpr_date, int ovtm_untp_bsop_hour, int ovtm_untp_prpr, int ovtm_untp_prdy_vrss, String ovtm_untp_prdy_vrss_sign, int ovtm_untp_askp1, int ovtm_untp_bidp1, long ovtm_untp_vol, long ovtm_untp_tr_pbmn, int ovtm_untp_oprc, int ovtm_untp_hgpr, int ovtm_untp_lwpr, long mkob_otcp_vol, long mkob_otcp_tr_pbmn, long mkfa_otcp_vol, long mkfa_otcp_tr_pbmn, String mrkt_div_cls_code, long pstc_dvdn_amt, long lstn_stcn, int stck_sdpr, float stck_fcam, float wghn_avrg_stck_prc, float issu_limt_rate, long frgn_limt_qty, long oder_able_qty, String frgn_limt_exhs_cls_code, long frgn_hldn_qty, float frgn_hldn_rate, float hts_frgn_ehrt, float itmt_last_nav, float prdy_last_nav, float trc_errt, float dprt, long ssts_cntg_qty, long ssts_tr_pbmn, long frgn_ntby_qty, String flng_cls_code, float prtt_rate, float acml_prtt_rate, float stdv, float beta_cfcn, float crlt_cfcn, float bull_beta, float bear_beta, float bull_dvtn, float bear_dvtn, float bull_crlt, float bear_crlt, int stck_mxpr, int stck_llam, String icic_cls_code, long itmt_vol, long itmt_tr_pbmn, String fcam_mod_cls_code, String revl_issu_reas_code, long orgn_ntby_qty, int adj_prpr, int fn_oprc, int fn_hgpr, int fn_lwpr, int fn_prpr, long fn_acml_vol, long fn_acml_tr_pbmn, float fn_prtt_rate, String fn_flng_cls_code, int buyin_nor_prpr, int buyin_nor_prdy_vrss, long buyin_nor_vol, long buyin_nor_tr_pbmn, int buyin_tod_prpr, int buyin_tod_prdy_vrss, long buyin_tod_vol, long buyin_tod_tr_pbmn) {
            this.stnd_iscd = stnd_iscd;
            this.bsop_date = bsop_date;
            this.shrn_iscd = shrn_iscd;
            this.stck_prpr = stck_prpr;
            this.stck_oprc = stck_oprc;
            this.stck_hgpr = stck_hgpr;
            this.stck_lwpr = stck_lwpr;
            this.prdy_vrss_sign = prdy_vrss_sign;
            this.prdy_vrss = prdy_vrss;
            this.prdy_ctrt = prdy_ctrt;
            this.prdy_vol = prdy_vol;
            this.acml_vol = acml_vol;
            this.acml_tr_pbmn = acml_tr_pbmn;
            this.askp1 = askp1;
            this.bidp1 = bidp1;
            this.total_askp_rsqn = total_askp_rsqn;
            this.total_bidp_rsqn = total_bidp_rsqn;
            this.seln_cntg_smtn = seln_cntg_smtn;
            this.shnu_cntg_smtn = shnu_cntg_smtn;
            this.seln_tr_pbmn = seln_tr_pbmn;
            this.shnu_tr_pbmn = shnu_tr_pbmn;
            this.seln_cntg_csnu = seln_cntg_csnu;
            this.shnu_cntg_csnu = shnu_cntg_csnu;
            this.w52_hgpr = w52_hgpr;
            this.w52_lwpr = w52_lwpr;
            this.w52_hgpr_date = w52_hgpr_date;
            this.w52_lwpr_date = w52_lwpr_date;
            this.ovtm_untp_bsop_hour = ovtm_untp_bsop_hour;
            this.ovtm_untp_prpr = ovtm_untp_prpr;
            this.ovtm_untp_prdy_vrss = ovtm_untp_prdy_vrss;
            this.ovtm_untp_prdy_vrss_sign = ovtm_untp_prdy_vrss_sign;
            this.ovtm_untp_askp1 = ovtm_untp_askp1;
            this.ovtm_untp_bidp1 = ovtm_untp_bidp1;
            this.ovtm_untp_vol = ovtm_untp_vol;
            this.ovtm_untp_tr_pbmn = ovtm_untp_tr_pbmn;
            this.ovtm_untp_oprc = ovtm_untp_oprc;
            this.ovtm_untp_hgpr = ovtm_untp_hgpr;
            this.ovtm_untp_lwpr = ovtm_untp_lwpr;
            this.mkob_otcp_vol = mkob_otcp_vol;
            this.mkob_otcp_tr_pbmn = mkob_otcp_tr_pbmn;
            this.mkfa_otcp_vol = mkfa_otcp_vol;
            this.mkfa_otcp_tr_pbmn = mkfa_otcp_tr_pbmn;
            this.mrkt_div_cls_code = mrkt_div_cls_code;
            this.pstc_dvdn_amt = pstc_dvdn_amt;
            this.lstn_stcn = lstn_stcn;
            this.stck_sdpr = stck_sdpr;
            this.stck_fcam = stck_fcam;
            this.wghn_avrg_stck_prc = wghn_avrg_stck_prc;
            this.issu_limt_rate = issu_limt_rate;
            this.frgn_limt_qty = frgn_limt_qty;
            this.oder_able_qty = oder_able_qty;
            this.frgn_limt_exhs_cls_code = frgn_limt_exhs_cls_code;
            this.frgn_hldn_qty = frgn_hldn_qty;
            this.frgn_hldn_rate = frgn_hldn_rate;
            this.hts_frgn_ehrt = hts_frgn_ehrt;
            this.itmt_last_nav = itmt_last_nav;
            this.prdy_last_nav = prdy_last_nav;
            this.trc_errt = trc_errt;
            this.dprt = dprt;
            this.ssts_cntg_qty = ssts_cntg_qty;
            this.ssts_tr_pbmn = ssts_tr_pbmn;
            this.frgn_ntby_qty = frgn_ntby_qty;
            this.flng_cls_code = flng_cls_code;
            this.prtt_rate = prtt_rate;
            this.acml_prtt_rate = acml_prtt_rate;
            this.stdv = stdv;
            this.beta_cfcn = beta_cfcn;
            this.crlt_cfcn = crlt_cfcn;
            this.bull_beta = bull_beta;
            this.bear_beta = bear_beta;
            this.bull_dvtn = bull_dvtn;
            this.bear_dvtn = bear_dvtn;
            this.bull_crlt = bull_crlt;
            this.bear_crlt = bear_crlt;
            this.stck_mxpr = stck_mxpr;
            this.stck_llam = stck_llam;
            this.icic_cls_code = icic_cls_code;
            this.itmt_vol = itmt_vol;
            this.itmt_tr_pbmn = itmt_tr_pbmn;
            this.fcam_mod_cls_code = fcam_mod_cls_code;
            this.revl_issu_reas_code = revl_issu_reas_code;
            this.orgn_ntby_qty = orgn_ntby_qty;
            this.adj_prpr = adj_prpr;
            this.fn_oprc = fn_oprc;
            this.fn_hgpr = fn_hgpr;
            this.fn_lwpr = fn_lwpr;
            this.fn_prpr = fn_prpr;
            this.fn_acml_vol = fn_acml_vol;
            this.fn_acml_tr_pbmn = fn_acml_tr_pbmn;
            this.fn_prtt_rate = fn_prtt_rate;
            this.fn_flng_cls_code = fn_flng_cls_code;
            this.buyin_nor_prpr = buyin_nor_prpr;
            this.buyin_nor_prdy_vrss = buyin_nor_prdy_vrss;
            this.buyin_nor_vol = buyin_nor_vol;
            this.buyin_nor_tr_pbmn = buyin_nor_tr_pbmn;
            this.buyin_tod_prpr = buyin_tod_prpr;
            this.buyin_tod_prdy_vrss = buyin_tod_prdy_vrss;
            this.buyin_tod_vol = buyin_tod_vol;
            this.buyin_tod_tr_pbmn = buyin_tod_tr_pbmn;
        }

        public Stock(String stnd_iscd, int bsop_date, String shrn_iscd, int stck_prpr, int stck_oprc, int stck_hgpr, int stck_lwpr, String prdy_vrss_sign, int prdy_vrss, float prdy_ctrt, long prdy_vol, long acml_vol, long acml_tr_pbmn, int askp1, int bidp1, long total_askp_rsqn, long total_bidp_rsqn, long seln_cntg_smtn, long shnu_cntg_smtn, long seln_tr_pbmn, long shnu_tr_pbmn, int seln_cntg_csnu, int shnu_cntg_csnu, int w52_hgpr, int w52_lwpr, int w52_hgpr_date, int w52_lwpr_date, int ovtm_untp_bsop_hour, int ovtm_untp_prpr, int ovtm_untp_prdy_vrss, String ovtm_untp_prdy_vrss_sign, int ovtm_untp_askp1, int ovtm_untp_bidp1, long ovtm_untp_vol, long ovtm_untp_tr_pbmn, int ovtm_untp_oprc, int ovtm_untp_hgpr, int ovtm_untp_lwpr, long mkob_otcp_vol, long mkob_otcp_tr_pbmn, long mkfa_otcp_vol, long mkfa_otcp_tr_pbmn, String mrkt_div_cls_code, long pstc_dvdn_amt, long lstn_stcn, int stck_sdpr, float stck_fcam, float wghn_avrg_stck_prc, float issu_limt_rate, long frgn_limt_qty, long oder_able_qty, String frgn_limt_exhs_cls_code, long frgn_hldn_qty, float frgn_hldn_rate, float hts_frgn_ehrt, float itmt_last_nav, float prdy_last_nav, float trc_errt, float dprt, long ssts_cntg_qty, long ssts_tr_pbmn, long frgn_ntby_qty, String flng_cls_code, float prtt_rate, float acml_prtt_rate, float stdv, float beta_cfcn, float crlt_cfcn, float bull_beta, float bear_beta, float bull_dvtn, float bear_dvtn, float bull_crlt, float bear_crlt, int stck_mxpr, int stck_llam, String icic_cls_code, long itmt_vol, long itmt_tr_pbmn, String fcam_mod_cls_code, String revl_issu_reas_code, long orgn_ntby_qty) {
            this.stnd_iscd = stnd_iscd;
            this.bsop_date = bsop_date;
            this.shrn_iscd = shrn_iscd;
            this.stck_prpr = stck_prpr;
            this.stck_oprc = stck_oprc;
            this.stck_hgpr = stck_hgpr;
            this.stck_lwpr = stck_lwpr;
            this.prdy_vrss_sign = prdy_vrss_sign;
            this.prdy_vrss = prdy_vrss;
            this.prdy_ctrt = prdy_ctrt;
            this.prdy_vol = prdy_vol;
            this.acml_vol = acml_vol;
            this.acml_tr_pbmn = acml_tr_pbmn;
            this.askp1 = askp1;
            this.bidp1 = bidp1;
            this.total_askp_rsqn = total_askp_rsqn;
            this.total_bidp_rsqn = total_bidp_rsqn;
            this.seln_cntg_smtn = seln_cntg_smtn;
            this.shnu_cntg_smtn = shnu_cntg_smtn;
            this.seln_tr_pbmn = seln_tr_pbmn;
            this.shnu_tr_pbmn = shnu_tr_pbmn;
            this.seln_cntg_csnu = seln_cntg_csnu;
            this.shnu_cntg_csnu = shnu_cntg_csnu;
            this.w52_hgpr = w52_hgpr;
            this.w52_lwpr = w52_lwpr;
            this.w52_hgpr_date = w52_hgpr_date;
            this.w52_lwpr_date = w52_lwpr_date;
            this.ovtm_untp_bsop_hour = ovtm_untp_bsop_hour;
            this.ovtm_untp_prpr = ovtm_untp_prpr;
            this.ovtm_untp_prdy_vrss = ovtm_untp_prdy_vrss;
            this.ovtm_untp_prdy_vrss_sign = ovtm_untp_prdy_vrss_sign;
            this.ovtm_untp_askp1 = ovtm_untp_askp1;
            this.ovtm_untp_bidp1 = ovtm_untp_bidp1;
            this.ovtm_untp_vol = ovtm_untp_vol;
            this.ovtm_untp_tr_pbmn = ovtm_untp_tr_pbmn;
            this.ovtm_untp_oprc = ovtm_untp_oprc;
            this.ovtm_untp_hgpr = ovtm_untp_hgpr;
            this.ovtm_untp_lwpr = ovtm_untp_lwpr;
            this.mkob_otcp_vol = mkob_otcp_vol;
            this.mkob_otcp_tr_pbmn = mkob_otcp_tr_pbmn;
            this.mkfa_otcp_vol = mkfa_otcp_vol;
            this.mkfa_otcp_tr_pbmn = mkfa_otcp_tr_pbmn;
            this.mrkt_div_cls_code = mrkt_div_cls_code;
            this.pstc_dvdn_amt = pstc_dvdn_amt;
            this.lstn_stcn = lstn_stcn;
            this.stck_sdpr = stck_sdpr;
            this.stck_fcam = stck_fcam;
            this.wghn_avrg_stck_prc = wghn_avrg_stck_prc;
            this.issu_limt_rate = issu_limt_rate;
            this.frgn_limt_qty = frgn_limt_qty;
            this.oder_able_qty = oder_able_qty;
            this.frgn_limt_exhs_cls_code = frgn_limt_exhs_cls_code;
            this.frgn_hldn_qty = frgn_hldn_qty;
            this.frgn_hldn_rate = frgn_hldn_rate;
            this.hts_frgn_ehrt = hts_frgn_ehrt;
            this.itmt_last_nav = itmt_last_nav;
            this.prdy_last_nav = prdy_last_nav;
            this.trc_errt = trc_errt;
            this.dprt = dprt;
            this.ssts_cntg_qty = ssts_cntg_qty;
            this.ssts_tr_pbmn = ssts_tr_pbmn;
            this.frgn_ntby_qty = frgn_ntby_qty;
            this.flng_cls_code = flng_cls_code;
            this.prtt_rate = prtt_rate;
            this.acml_prtt_rate = acml_prtt_rate;
            this.stdv = stdv;
            this.beta_cfcn = beta_cfcn;
            this.crlt_cfcn = crlt_cfcn;
            this.bull_beta = bull_beta;
            this.bear_beta = bear_beta;
            this.bull_dvtn = bull_dvtn;
            this.bear_dvtn = bear_dvtn;
            this.bull_crlt = bull_crlt;
            this.bear_crlt = bear_crlt;
            this.stck_mxpr = stck_mxpr;
            this.stck_llam = stck_llam;
            this.icic_cls_code = icic_cls_code;
            this.itmt_vol = itmt_vol;
            this.itmt_tr_pbmn = itmt_tr_pbmn;
            this.fcam_mod_cls_code = fcam_mod_cls_code;
            this.revl_issu_reas_code = revl_issu_reas_code;
            this.orgn_ntby_qty = orgn_ntby_qty;
        }

        public Stock(String stnd_iscd, int bsop_date, String shrn_iscd, int stck_prpr, int stck_oprc, int stck_hgpr, int stck_lwpr, String prdy_vrss_sign, int prdy_vrss, float prdy_ctrt, long prdy_vol, long acml_vol, long acml_tr_pbmn, int askp1, int bidp1, long total_askp_rsqn, long total_bidp_rsqn, long seln_cntg_smtn, long shnu_cntg_smtn, long seln_tr_pbmn, long shnu_tr_pbmn, int seln_cntg_csnu, int shnu_cntg_csnu, int w52_hgpr, int w52_lwpr, int w52_hgpr_date, int w52_lwpr_date, int ovtm_untp_bsop_hour, int ovtm_untp_prpr, int ovtm_untp_prdy_vrss, String ovtm_untp_prdy_vrss_sign, int ovtm_untp_askp1, int ovtm_untp_bidp1, long ovtm_untp_vol, long ovtm_untp_tr_pbmn, int ovtm_untp_oprc, int ovtm_untp_hgpr, int ovtm_untp_lwpr, long mkob_otcp_vol, long mkob_otcp_tr_pbmn, long mkfa_otcp_vol, long mkfa_otcp_tr_pbmn, String mrkt_div_cls_code, long pstc_dvdn_amt, long lstn_stcn, int stck_sdpr, float stck_fcam, float wghn_avrg_stck_prc, float issu_limt_rate, long frgn_limt_qty, long oder_able_qty, String frgn_limt_exhs_cls_code, long frgn_hldn_qty, float frgn_hldn_rate, float hts_frgn_ehrt, float itmt_last_nav, float prdy_last_nav, float trc_errt, float dprt, long ssts_cntg_qty, long ssts_tr_pbmn, long frgn_ntby_qty, String flng_cls_code, float prtt_rate, float acml_prtt_rate, float stdv, float beta_cfcn, float crlt_cfcn, float bull_beta, float bear_beta, float bull_dvtn, float bear_dvtn, float bull_crlt, float bear_crlt, int stck_mxpr, int stck_llam, String icic_cls_code, long itmt_vol, long itmt_tr_pbmn, String fcam_mod_cls_code, String revl_issu_reas_code) {
            this.stnd_iscd = stnd_iscd;
            this.bsop_date = bsop_date;
            this.shrn_iscd = shrn_iscd;
            this.stck_prpr = stck_prpr;
            this.stck_oprc = stck_oprc;
            this.stck_hgpr = stck_hgpr;
            this.stck_lwpr = stck_lwpr;
            this.prdy_vrss_sign = prdy_vrss_sign;
            this.prdy_vrss = prdy_vrss;
            this.prdy_ctrt = prdy_ctrt;
            this.prdy_vol = prdy_vol;
            this.acml_vol = acml_vol;
            this.acml_tr_pbmn = acml_tr_pbmn;
            this.askp1 = askp1;
            this.bidp1 = bidp1;
            this.total_askp_rsqn = total_askp_rsqn;
            this.total_bidp_rsqn = total_bidp_rsqn;
            this.seln_cntg_smtn = seln_cntg_smtn;
            this.shnu_cntg_smtn = shnu_cntg_smtn;
            this.seln_tr_pbmn = seln_tr_pbmn;
            this.shnu_tr_pbmn = shnu_tr_pbmn;
            this.seln_cntg_csnu = seln_cntg_csnu;
            this.shnu_cntg_csnu = shnu_cntg_csnu;
            this.w52_hgpr = w52_hgpr;
            this.w52_lwpr = w52_lwpr;
            this.w52_hgpr_date = w52_hgpr_date;
            this.w52_lwpr_date = w52_lwpr_date;
            this.ovtm_untp_bsop_hour = ovtm_untp_bsop_hour;
            this.ovtm_untp_prpr = ovtm_untp_prpr;
            this.ovtm_untp_prdy_vrss = ovtm_untp_prdy_vrss;
            this.ovtm_untp_prdy_vrss_sign = ovtm_untp_prdy_vrss_sign;
            this.ovtm_untp_askp1 = ovtm_untp_askp1;
            this.ovtm_untp_bidp1 = ovtm_untp_bidp1;
            this.ovtm_untp_vol = ovtm_untp_vol;
            this.ovtm_untp_tr_pbmn = ovtm_untp_tr_pbmn;
            this.ovtm_untp_oprc = ovtm_untp_oprc;
            this.ovtm_untp_hgpr = ovtm_untp_hgpr;
            this.ovtm_untp_lwpr = ovtm_untp_lwpr;
            this.mkob_otcp_vol = mkob_otcp_vol;
            this.mkob_otcp_tr_pbmn = mkob_otcp_tr_pbmn;
            this.mkfa_otcp_vol = mkfa_otcp_vol;
            this.mkfa_otcp_tr_pbmn = mkfa_otcp_tr_pbmn;
            this.mrkt_div_cls_code = mrkt_div_cls_code;
            this.pstc_dvdn_amt = pstc_dvdn_amt;
            this.lstn_stcn = lstn_stcn;
            this.stck_sdpr = stck_sdpr;
            this.stck_fcam = stck_fcam;
            this.wghn_avrg_stck_prc = wghn_avrg_stck_prc;
            this.issu_limt_rate = issu_limt_rate;
            this.frgn_limt_qty = frgn_limt_qty;
            this.oder_able_qty = oder_able_qty;
            this.frgn_limt_exhs_cls_code = frgn_limt_exhs_cls_code;
            this.frgn_hldn_qty = frgn_hldn_qty;
            this.frgn_hldn_rate = frgn_hldn_rate;
            this.hts_frgn_ehrt = hts_frgn_ehrt;
            this.itmt_last_nav = itmt_last_nav;
            this.prdy_last_nav = prdy_last_nav;
            this.trc_errt = trc_errt;
            this.dprt = dprt;
            this.ssts_cntg_qty = ssts_cntg_qty;
            this.ssts_tr_pbmn = ssts_tr_pbmn;
            this.frgn_ntby_qty = frgn_ntby_qty;
            this.flng_cls_code = flng_cls_code;
            this.prtt_rate = prtt_rate;
            this.acml_prtt_rate = acml_prtt_rate;
            this.stdv = stdv;
            this.beta_cfcn = beta_cfcn;
            this.crlt_cfcn = crlt_cfcn;
            this.bull_beta = bull_beta;
            this.bear_beta = bear_beta;
            this.bull_dvtn = bull_dvtn;
            this.bear_dvtn = bear_dvtn;
            this.bull_crlt = bull_crlt;
            this.bear_crlt = bear_crlt;
            this.stck_mxpr = stck_mxpr;
            this.stck_llam = stck_llam;
            this.icic_cls_code = icic_cls_code;
            this.itmt_vol = itmt_vol;
            this.itmt_tr_pbmn = itmt_tr_pbmn;
            this.fcam_mod_cls_code = fcam_mod_cls_code;
            this.revl_issu_reas_code = revl_issu_reas_code;
        }

        public Stock(String stnd_iscd, int bsop_date, String shrn_iscd, int stck_prpr, int stck_oprc, int stck_hgpr, int stck_lwpr, String prdy_vrss_sign, int prdy_vrss, float prdy_ctrt, long prdy_vol, long acml_vol, long acml_tr_pbmn, int askp1, int bidp1, long total_askp_rsqn, long total_bidp_rsqn, long seln_cntg_smtn, long shnu_cntg_smtn, long seln_tr_pbmn, long shnu_tr_pbmn, int seln_cntg_csnu, int shnu_cntg_csnu, int w52_hgpr, int w52_lwpr, int w52_hgpr_date, int w52_lwpr_date, int ovtm_untp_bsop_hour, int ovtm_untp_prpr, int ovtm_untp_prdy_vrss, String ovtm_untp_prdy_vrss_sign, int ovtm_untp_askp1, int ovtm_untp_bidp1, long ovtm_untp_vol, long ovtm_untp_tr_pbmn, int ovtm_untp_oprc, int ovtm_untp_hgpr, int ovtm_untp_lwpr, long mkob_otcp_vol, long mkob_otcp_tr_pbmn, long mkfa_otcp_vol, long mkfa_otcp_tr_pbmn, String mrkt_div_cls_code, long pstc_dvdn_amt, long lstn_stcn, int stck_sdpr, float stck_fcam, float wghn_avrg_stck_prc, float issu_limt_rate, long frgn_limt_qty, long oder_able_qty, String frgn_limt_exhs_cls_code, long frgn_hldn_qty, float frgn_hldn_rate, float hts_frgn_ehrt, float itmt_last_nav, float prdy_last_nav, float trc_errt, float dprt, long ssts_cntg_qty, long ssts_tr_pbmn, long frgn_ntby_qty, String flng_cls_code, float prtt_rate, float acml_prtt_rate, float stdv, float beta_cfcn, float crlt_cfcn, float bull_beta, float bear_beta, float bull_dvtn, float bear_dvtn, float bull_crlt, float bear_crlt, int stck_mxpr, int stck_llam, String icic_cls_code, long itmt_vol, long itmt_tr_pbmn, String fcam_mod_cls_code, String revl_issu_reas_code, long orgn_ntby_qty, int adj_prpr, int fn_oprc, int fn_hgpr, int fn_lwpr, int fn_prpr, long fn_acml_vol, long fn_acml_tr_pbmn, float fn_prtt_rate, String fn_flng_cls_code) {
            this.stnd_iscd = stnd_iscd;
            this.bsop_date = bsop_date;
            this.shrn_iscd = shrn_iscd;
            this.stck_prpr = stck_prpr;
            this.stck_oprc = stck_oprc;
            this.stck_hgpr = stck_hgpr;
            this.stck_lwpr = stck_lwpr;
            this.prdy_vrss_sign = prdy_vrss_sign;
            this.prdy_vrss = prdy_vrss;
            this.prdy_ctrt = prdy_ctrt;
            this.prdy_vol = prdy_vol;
            this.acml_vol = acml_vol;
            this.acml_tr_pbmn = acml_tr_pbmn;
            this.askp1 = askp1;
            this.bidp1 = bidp1;
            this.total_askp_rsqn = total_askp_rsqn;
            this.total_bidp_rsqn = total_bidp_rsqn;
            this.seln_cntg_smtn = seln_cntg_smtn;
            this.shnu_cntg_smtn = shnu_cntg_smtn;
            this.seln_tr_pbmn = seln_tr_pbmn;
            this.shnu_tr_pbmn = shnu_tr_pbmn;
            this.seln_cntg_csnu = seln_cntg_csnu;
            this.shnu_cntg_csnu = shnu_cntg_csnu;
            this.w52_hgpr = w52_hgpr;
            this.w52_lwpr = w52_lwpr;
            this.w52_hgpr_date = w52_hgpr_date;
            this.w52_lwpr_date = w52_lwpr_date;
            this.ovtm_untp_bsop_hour = ovtm_untp_bsop_hour;
            this.ovtm_untp_prpr = ovtm_untp_prpr;
            this.ovtm_untp_prdy_vrss = ovtm_untp_prdy_vrss;
            this.ovtm_untp_prdy_vrss_sign = ovtm_untp_prdy_vrss_sign;
            this.ovtm_untp_askp1 = ovtm_untp_askp1;
            this.ovtm_untp_bidp1 = ovtm_untp_bidp1;
            this.ovtm_untp_vol = ovtm_untp_vol;
            this.ovtm_untp_tr_pbmn = ovtm_untp_tr_pbmn;
            this.ovtm_untp_oprc = ovtm_untp_oprc;
            this.ovtm_untp_hgpr = ovtm_untp_hgpr;
            this.ovtm_untp_lwpr = ovtm_untp_lwpr;
            this.mkob_otcp_vol = mkob_otcp_vol;
            this.mkob_otcp_tr_pbmn = mkob_otcp_tr_pbmn;
            this.mkfa_otcp_vol = mkfa_otcp_vol;
            this.mkfa_otcp_tr_pbmn = mkfa_otcp_tr_pbmn;
            this.mrkt_div_cls_code = mrkt_div_cls_code;
            this.pstc_dvdn_amt = pstc_dvdn_amt;
            this.lstn_stcn = lstn_stcn;
            this.stck_sdpr = stck_sdpr;
            this.stck_fcam = stck_fcam;
            this.wghn_avrg_stck_prc = wghn_avrg_stck_prc;
            this.issu_limt_rate = issu_limt_rate;
            this.frgn_limt_qty = frgn_limt_qty;
            this.oder_able_qty = oder_able_qty;
            this.frgn_limt_exhs_cls_code = frgn_limt_exhs_cls_code;
            this.frgn_hldn_qty = frgn_hldn_qty;
            this.frgn_hldn_rate = frgn_hldn_rate;
            this.hts_frgn_ehrt = hts_frgn_ehrt;
            this.itmt_last_nav = itmt_last_nav;
            this.prdy_last_nav = prdy_last_nav;
            this.trc_errt = trc_errt;
            this.dprt = dprt;
            this.ssts_cntg_qty = ssts_cntg_qty;
            this.ssts_tr_pbmn = ssts_tr_pbmn;
            this.frgn_ntby_qty = frgn_ntby_qty;
            this.flng_cls_code = flng_cls_code;
            this.prtt_rate = prtt_rate;
            this.acml_prtt_rate = acml_prtt_rate;
            this.stdv = stdv;
            this.beta_cfcn = beta_cfcn;
            this.crlt_cfcn = crlt_cfcn;
            this.bull_beta = bull_beta;
            this.bear_beta = bear_beta;
            this.bull_dvtn = bull_dvtn;
            this.bear_dvtn = bear_dvtn;
            this.bull_crlt = bull_crlt;
            this.bear_crlt = bear_crlt;
            this.stck_mxpr = stck_mxpr;
            this.stck_llam = stck_llam;
            this.icic_cls_code = icic_cls_code;
            this.itmt_vol = itmt_vol;
            this.itmt_tr_pbmn = itmt_tr_pbmn;
            this.fcam_mod_cls_code = fcam_mod_cls_code;
            this.revl_issu_reas_code = revl_issu_reas_code;
            this.orgn_ntby_qty = orgn_ntby_qty;
            this.adj_prpr = adj_prpr;
            this.fn_oprc = fn_oprc;
            this.fn_hgpr = fn_hgpr;
            this.fn_lwpr = fn_lwpr;
            this.fn_prpr = fn_prpr;
            this.fn_acml_vol = fn_acml_vol;
            this.fn_acml_tr_pbmn = fn_acml_tr_pbmn;
            this.fn_prtt_rate = fn_prtt_rate;
            this.fn_flng_cls_code = fn_flng_cls_code;
        }

        public Stock(String stnd_iscd, int bsop_date, String shrn_iscd, int stck_prpr, int stck_oprc, int stck_hgpr, int stck_lwpr, String prdy_vrss_sign, int prdy_vrss, float prdy_ctrt, long prdy_vol, long acml_vol, long acml_tr_pbmn, int askp1, int bidp1, long total_askp_rsqn, long total_bidp_rsqn, long seln_cntg_smtn, long shnu_cntg_smtn, long seln_tr_pbmn, long shnu_tr_pbmn, int seln_cntg_csnu, int shnu_cntg_csnu, int w52_hgpr, int w52_lwpr, int w52_hgpr_date, int w52_lwpr_date, int ovtm_untp_bsop_hour, int ovtm_untp_prpr, int ovtm_untp_prdy_vrss, String ovtm_untp_prdy_vrss_sign, int ovtm_untp_askp1, int ovtm_untp_bidp1, long ovtm_untp_vol, long ovtm_untp_tr_pbmn, int ovtm_untp_oprc, int ovtm_untp_hgpr, int ovtm_untp_lwpr, long mkob_otcp_vol, long mkob_otcp_tr_pbmn, long mkfa_otcp_vol, long mkfa_otcp_tr_pbmn, String mrkt_div_cls_code, long pstc_dvdn_amt, long lstn_stcn, int stck_sdpr, float stck_fcam, float wghn_avrg_stck_prc, float issu_limt_rate, long frgn_limt_qty, long oder_able_qty, String frgn_limt_exhs_cls_code, long frgn_hldn_qty, float frgn_hldn_rate, float hts_frgn_ehrt, float itmt_last_nav, float prdy_last_nav, float trc_errt, float dprt, long ssts_cntg_qty, long ssts_tr_pbmn, long frgn_ntby_qty, String flng_cls_code, float prtt_rate, float acml_prtt_rate) {
            this.stnd_iscd = stnd_iscd;
            this.bsop_date = bsop_date;
            this.shrn_iscd = shrn_iscd;
            this.stck_prpr = stck_prpr;
            this.stck_oprc = stck_oprc;
            this.stck_hgpr = stck_hgpr;
            this.stck_lwpr = stck_lwpr;
            this.prdy_vrss_sign = prdy_vrss_sign;
            this.prdy_vrss = prdy_vrss;
            this.prdy_ctrt = prdy_ctrt;
            this.prdy_vol = prdy_vol;
            this.acml_vol = acml_vol;
            this.acml_tr_pbmn = acml_tr_pbmn;
            this.askp1 = askp1;
            this.bidp1 = bidp1;
            this.total_askp_rsqn = total_askp_rsqn;
            this.total_bidp_rsqn = total_bidp_rsqn;
            this.seln_cntg_smtn = seln_cntg_smtn;
            this.shnu_cntg_smtn = shnu_cntg_smtn;
            this.seln_tr_pbmn = seln_tr_pbmn;
            this.shnu_tr_pbmn = shnu_tr_pbmn;
            this.seln_cntg_csnu = seln_cntg_csnu;
            this.shnu_cntg_csnu = shnu_cntg_csnu;
            this.w52_hgpr = w52_hgpr;
            this.w52_lwpr = w52_lwpr;
            this.w52_hgpr_date = w52_hgpr_date;
            this.w52_lwpr_date = w52_lwpr_date;
            this.ovtm_untp_bsop_hour = ovtm_untp_bsop_hour;
            this.ovtm_untp_prpr = ovtm_untp_prpr;
            this.ovtm_untp_prdy_vrss = ovtm_untp_prdy_vrss;
            this.ovtm_untp_prdy_vrss_sign = ovtm_untp_prdy_vrss_sign;
            this.ovtm_untp_askp1 = ovtm_untp_askp1;
            this.ovtm_untp_bidp1 = ovtm_untp_bidp1;
            this.ovtm_untp_vol = ovtm_untp_vol;
            this.ovtm_untp_tr_pbmn = ovtm_untp_tr_pbmn;
            this.ovtm_untp_oprc = ovtm_untp_oprc;
            this.ovtm_untp_hgpr = ovtm_untp_hgpr;
            this.ovtm_untp_lwpr = ovtm_untp_lwpr;
            this.mkob_otcp_vol = mkob_otcp_vol;
            this.mkob_otcp_tr_pbmn = mkob_otcp_tr_pbmn;
            this.mkfa_otcp_vol = mkfa_otcp_vol;
            this.mkfa_otcp_tr_pbmn = mkfa_otcp_tr_pbmn;
            this.mrkt_div_cls_code = mrkt_div_cls_code;
            this.pstc_dvdn_amt = pstc_dvdn_amt;
            this.lstn_stcn = lstn_stcn;
            this.stck_sdpr = stck_sdpr;
            this.stck_fcam = stck_fcam;
            this.wghn_avrg_stck_prc = wghn_avrg_stck_prc;
            this.issu_limt_rate = issu_limt_rate;
            this.frgn_limt_qty = frgn_limt_qty;
            this.oder_able_qty = oder_able_qty;
            this.frgn_limt_exhs_cls_code = frgn_limt_exhs_cls_code;
            this.frgn_hldn_qty = frgn_hldn_qty;
            this.frgn_hldn_rate = frgn_hldn_rate;
            this.hts_frgn_ehrt = hts_frgn_ehrt;
            this.itmt_last_nav = itmt_last_nav;
            this.prdy_last_nav = prdy_last_nav;
            this.trc_errt = trc_errt;
            this.dprt = dprt;
            this.ssts_cntg_qty = ssts_cntg_qty;
            this.ssts_tr_pbmn = ssts_tr_pbmn;
            this.frgn_ntby_qty = frgn_ntby_qty;
            this.flng_cls_code = flng_cls_code;
            this.prtt_rate = prtt_rate;
            this.acml_prtt_rate = acml_prtt_rate;
        }
    }
}

