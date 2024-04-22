/*
             
*/

import java.util.*;

class ProjectFuzzy{
    class Suhu{

        public double data_suhu;

        private double rendah(){
            if((data_suhu>=18)&&(data_suhu<=22)){
                return (data_suhu - 18.0) / 4.0;
            }
            else if((data_suhu>=22)&&(data_suhu<=26)){
                return (26.0 - data_suhu) / 4.0;
            }
            else{
                return 0;
            }
        }

        private double normal(){
            if((data_suhu>=22)&&(data_suhu<=26)){
                return (data_suhu - 22.0) / 4.0;
            }
            else if((data_suhu>=26)&&(data_suhu<=32)){
                return (32.0 - data_suhu) / 6.0;
            }
            else{
                return 0;
            }
        }

        private double tinggi(){
            if((data_suhu>=26)&&(data_suhu<=32)){
                return (data_suhu - 26.0) / 6.0;
            }
            else if((data_suhu>=32)&&(data_suhu<=38)){
                return (38.0 - data_suhu) / 6.0;
            }
            else{
                return 0;
            }
        }
    }

    class Kebisingan{

        public double data_kebisingan;

        private double tenang(){
            if((data_kebisingan>=35)&&(data_kebisingan<=55)){
                return (data_kebisingan - 35.0) / 20.0;
            }
            else if((data_kebisingan>=55)&&(data_kebisingan<=75)){
                return (75.0 - data_kebisingan) / 20.0;
            }
            else{
                return 0;
            }
        }

        private double agakbising(){
            if((data_kebisingan>=55)&&(data_kebisingan<=75)){
                return (data_kebisingan - 55.0) / 20.0;
            }
            else if((data_kebisingan>=75)&&(data_kebisingan<=90)){
                return (90.0 - data_kebisingan) / 15.0;
            }
            else{
                return 0;
            }
        }

        private double bising(){
            if((data_kebisingan>=75)&&(data_kebisingan<=90)){
                return (data_kebisingan - 75.0) / 15.0;
            }
            else if((data_kebisingan>=90)&&(data_kebisingan<=105)){
                return (105.0 - data_kebisingan) / 15.0;
            }
            else{
                return 0;
            }
        }
    }

    class Pencahayaan{

        public double data_pencahayaan;

        private double redup(){
            if((data_pencahayaan>=0)&&(data_pencahayaan<=150)){
                return (data_pencahayaan / 15.0);
            }
            else if((data_pencahayaan>=150)&&(data_pencahayaan<=300)){
                return (300.0 - data_pencahayaan) / 150.0;
            }
            else{
                return 0;
            }
        }

        private double agakterang(){
            if((data_pencahayaan>=150)&&(data_pencahayaan<=300)){
                return ((data_pencahayaan - 150.0) / 150.0);
            }
            else if((data_pencahayaan>=300)&&(data_pencahayaan<=500)){
                return (500.0 - data_pencahayaan) / 200.0;
            }
            else{
                return 0;
            }
        }

        private double terang(){
            if((data_pencahayaan>=300)&&(data_pencahayaan<=500)){
                return ((data_pencahayaan - 300.0) / 200.0);
            }
            else if((data_pencahayaan>=500)&&(data_pencahayaan<=700)){
                return (700.0 - data_pencahayaan) / 200.0;
            }
            else{
                return 0;
            }
        }
    }

    class Produk{

        double [] rata_rata_product;

        Produk(){

           rata_rata_product = new double[27];

           rata_rata_product[0] = 148.00;

           rata_rata_product[1] = 150.90;

           rata_rata_product[2] = 146.50;

           rata_rata_product[3] = 143.10;

           rata_rata_product[4] = 146.53;

           rata_rata_product[5] = 142.73;

           rata_rata_product[6] = 136.73;

           rata_rata_product[7] = 140.77;

           rata_rata_product[8] = 135.97;

           rata_rata_product[9] = 149.73;

           rata_rata_product[10] = 153.27;

           rata_rata_product[11] = 152.13;

           rata_rata_product[12] = 148.00;

           rata_rata_product[13] = 150.63;

           rata_rata_product[14] = 147.63;

           rata_rata_product[15] = 141.47;

           rata_rata_product[16] = 145.67;

           rata_rata_product[17] = 140.20;

           rata_rata_product[18] = 142.10;

           rata_rata_product[19] = 146.53;

           rata_rata_product[20] = 142.17;

           rata_rata_product[21] = 138.70;

           rata_rata_product[22] = 141.40;

           rata_rata_product[23] = 138.30;

           rata_rata_product[24] = 133.33;

           rata_rata_product[25] = 138.53;

           rata_rata_product[26] = 133.77;

        }
    }

    private void Compute_Membership(){
        suhu = new Suhu();
        kebisingan = new Kebisingan();
        pencahayaan = new Pencahayaan();

        suhu.data_suhu = kondisi_suhu;
        u_suhu_rendah = suhu.rendah();
        u_suhu_normal = suhu.normal();
        u_suhu_tinggi = suhu.tinggi();

        kebisingan.data_kebisingan = kondisi_kebisingan;
        u_kebisingan_tenang = kebisingan.tenang();
        u_kebisingan_agakbising = kebisingan.agakbising();
        u_kebisingan_bising = kebisingan.bising();

        pencahayaan.data_pencahayaan = kondisi_pencahayaan;
        u_pencahayaan_redup = pencahayaan.redup();
        u_pencahayaan_agakterang = pencahayaan.agakterang();
        u_pencahayaan_terang = pencahayaan.terang();
    }

    private void Apply_Rule(){
        output_rule = new double[27];
        u_output = new double[27];
        produk = new Produk();
        //produk.initialize_data();

        //IF Suhu RENDAH and Kebisingan TENANG and Pencahayaan REDUP THEN Rata-rata product = 148.00;
        output_rule[0] = Find_Min(u_suhu_rendah, u_kebisingan_tenang, u_pencahayaan_redup);
        u_output[0] = produk.rata_rata_product[0];

        //IF Suhu RENDAH and Kebisingan TENANG and Pencahayaan AGAKTERANG THEN Rata-rata product = 150.90;
        output_rule[1] = Find_Min(u_suhu_rendah, u_kebisingan_tenang, u_pencahayaan_agakterang);
        u_output[1] = produk.rata_rata_product[1];

        //IF Suhu RENDAH and Kebisingan TENANG and Pencahayaan TERANG THEN Rata-rata product = 146.50;
        output_rule[2] = Find_Min(u_suhu_rendah, u_kebisingan_tenang, u_pencahayaan_terang);
        u_output[2] = produk.rata_rata_product[2];

        //IF Suhu RENDAH and Kebisingan AGAKBISING and Pencahayaan REDUP THEN Rata-rata product = 143.10;
        output_rule[3] = Find_Min(u_suhu_rendah, u_kebisingan_agakbising, u_pencahayaan_redup);
        u_output[3] = produk.rata_rata_product[3];

        //IF Suhu RENDAH and Kebisingan AGAKBISING and Pencahayaan AGAKTERANG THEN Rata-rata product = 146.53;
        output_rule[4] = Find_Min(u_suhu_rendah, u_kebisingan_agakbising, u_pencahayaan_agakterang);
        u_output[4] = produk.rata_rata_product[4];

        //IF Suhu RENDAH and Kebisingan AGAKBISING and Pencahayaan TERANG THEN Rata-rata product = 142.73;
        output_rule[5] = Find_Min(u_suhu_rendah, u_kebisingan_agakbising, u_pencahayaan_terang);
        u_output[5] = produk.rata_rata_product[5];

        //IF Suhu RENDAH and Kebisingan BISING and Pencahayaan REDUP THEN Rata-rata product = 136.73;
        output_rule[6] = Find_Min(u_suhu_rendah, u_kebisingan_bising, u_pencahayaan_redup);
        u_output[6] = produk.rata_rata_product[6];

        //IF Suhu RENDAH and Kebisingan BISING and Pencahayaan AGAKTERANG THEN Rata-rata product = 140.77;
        output_rule[7] = Find_Min(u_suhu_rendah, u_kebisingan_bising, u_pencahayaan_agakterang);
        u_output[7] = produk.rata_rata_product[7];

        //IF Suhu RENDAH and Kebisingan BISING and Pencahayaan TERANG THEN Rata-rata product = 135.97;
        output_rule[8] = Find_Min(u_suhu_rendah, u_kebisingan_bising, u_pencahayaan_terang);
        u_output[8] = produk.rata_rata_product[8];

        //IF Suhu NORMAL and Kebisingan TENANG and Pencahayaan REDUP THEN Rata-rata product = 149.73;
        output_rule[9] = Find_Min(u_suhu_normal, u_kebisingan_tenang, u_pencahayaan_redup);
        u_output[9] = produk.rata_rata_product[9];

        //IF Suhu NORMAL and Kebisingan TENANG and Pencahayaan AGAKTERANG THEN Rata-rata product = 153.27;
        output_rule[10] = Find_Min(u_suhu_normal, u_kebisingan_tenang, u_pencahayaan_agakterang);
        u_output[10] = produk.rata_rata_product[10];

        //IF Suhu NORMAL and Kebisingan TENANG and Pencahayaan TERANG THEN Rata-rata product = 152.13;
        output_rule[11] = Find_Min(u_suhu_normal, u_kebisingan_tenang, u_pencahayaan_terang);
        u_output[11] = produk.rata_rata_product[11];

        //IF Suhu NORMAL and Kebisingan AGAKBISING and Pencahayaan REDUP THEN Rata-rata product = 148.00;
        output_rule[12] = Find_Min(u_suhu_normal, u_kebisingan_agakbising, u_pencahayaan_redup);
        u_output[12] = produk.rata_rata_product[12];

        //IF Suhu NORMAL and Kebisingan AGAKBISING and Pencahayaan AGAKTERANG THEN Rata-rata product = 150.63;
        output_rule[13] = Find_Min(u_suhu_normal, u_kebisingan_agakbising, u_pencahayaan_agakterang);
        u_output[13] = produk.rata_rata_product[13];

        //IF Suhu NORMAL and Kebisingan AGAKBISING and Pencahayaan TERANG THEN Rata-rata product = 147.63;
        output_rule[14] = Find_Min(u_suhu_normal, u_kebisingan_agakbising, u_pencahayaan_terang);
        u_output[14] = produk.rata_rata_product[14];

        //IF Suhu NORMAL and Kebisingan BISING and Pencahayaan REDUP THEN Rata-rata product = 141.47;
        output_rule[15] = Find_Min(u_suhu_normal, u_kebisingan_bising, u_pencahayaan_redup);
        u_output[15] = produk.rata_rata_product[15];

        //IF Suhu NORMAL and Kebisingan BISING and Pencahayaan AGAKTERANG THEN Rata-rata product = 145.67;
        output_rule[16] = Find_Min(u_suhu_normal, u_kebisingan_bising, u_pencahayaan_agakterang);
        u_output[16] = produk.rata_rata_product[16];

        //IF Suhu NORMAL and Kebisingan BISING and Pencahayaan TERANG THEN Rata-rata product = 140.20;
        output_rule[17] = Find_Min(u_suhu_normal, u_kebisingan_bising, u_pencahayaan_terang);
        u_output[17] = produk.rata_rata_product[17];

        //IF Suhu TINGGI and Kebisingan TENANG and Pencahayaan REDUP THEN Rata-rata product = 142.10;
        output_rule[18] = Find_Min(u_suhu_tinggi, u_kebisingan_tenang, u_pencahayaan_redup);
        u_output[18] = produk.rata_rata_product[18];

        //IF Suhu TINGGI and Kebisingan TENANG and Pencahayaan AGAKTERANG THEN Rata-rata product = 146.53;
        output_rule[19] = Find_Min(u_suhu_tinggi, u_kebisingan_tenang, u_pencahayaan_agakterang);
        u_output[19] = produk.rata_rata_product[19];

        //IF Suhu TINGGI and Kebisingan TENANG and Pencahayaan TERANG THEN Rata-rata product = 142.17;
        output_rule[20] = Find_Min(u_suhu_tinggi, u_kebisingan_tenang, u_pencahayaan_terang);
        u_output[20] = produk.rata_rata_product[20];

        //IF Suhu TINGGI and Kebisingan AGAKBISING and Pencahayaan REDUP THEN Rata-rata product = 138.70;
        output_rule[21] = Find_Min(u_suhu_tinggi, u_kebisingan_agakbising, u_pencahayaan_redup);
        u_output[21] = produk.rata_rata_product[21];

        //IF Suhu TINGGI and Kebisingan AGAKBISING and Pencahayaan AGAKTERANG THEN Rata-rata product = 141.40;
        output_rule[22] = Find_Min(u_suhu_tinggi, u_kebisingan_agakbising, u_pencahayaan_agakterang);
        u_output[22] = produk.rata_rata_product[22];

        //IF Suhu TINGGI and Kebisingan AGAKBISING and Pencahayaan TERANG THEN Rata-rata product = 138.30;
        output_rule[23] = Find_Min(u_suhu_tinggi, u_kebisingan_agakbising, u_pencahayaan_terang);
        u_output[23] = produk.rata_rata_product[23];

        //IF Suhu TINGGI and Kebisingan BISING and Pencahayaan REDUP THEN Rata-rata product = 133.33;
        output_rule[24] = Find_Min(u_suhu_tinggi, u_kebisingan_bising, u_pencahayaan_redup);
        u_output[24] = produk.rata_rata_product[24];

        //IF Suhu TINGGI and Kebisingan BISING and Pencahayaan AGAKTERANG THEN Rata-rata product = 138.33;
        output_rule[25] = Find_Min(u_suhu_tinggi, u_kebisingan_bising, u_pencahayaan_agakterang);
        u_output[25] = produk.rata_rata_product[25];

        //IF Suhu TINGGI and Kebisingan BISING and Pencahayaan TERANG THEN Rata-rata product = 133.77;
        output_rule[26] = Find_Min(u_suhu_tinggi, u_kebisingan_bising, u_pencahayaan_terang);
        u_output[26] = produk.rata_rata_product[26];

    }

    private void Compute_Output(){
        double z = 0;
        double temp1 = 0;
        double temp2 = 0;

        for(int i=0;i<27;i++){
           temp1 += output_rule[i] * u_output[i];
           temp2 += output_rule[i];
        }

        //System.out.println("Temp1="+temp1);
        //System.out.println("Temp2="+temp2);

        z = temp1 / temp2;

        System.out.println("Fuzzy Out:" + z);
    }

    private double Find_Min(double a, double b, double c){
        double result;
        List<Double> list = new ArrayList<Double>(3);

        list.add(a);
        list.add(b);
        list.add(c);

        //Collections.sort(list);
        result = Collections.min(list);
        //System.out.println("Min:"+result);
        return result;
    }

    public void RunFuzzy(){
        Compute_Membership();
        Apply_Rule();
        Compute_Output();
    }

    public static void main(String[] args){
        ProjectFuzzy projectfuzzy = new ProjectFuzzy();

        projectfuzzy.kondisi_suhu = 26;
        System.out.println("Suhu:" + projectfuzzy.kondisi_suhu);
        projectfuzzy.kondisi_kebisingan = 55;
        System.out.println("Kebisingan:" + projectfuzzy.kondisi_kebisingan);
        projectfuzzy.kondisi_pencahayaan = 150;
        System.out.println("Pencahayaan:" + projectfuzzy.kondisi_pencahayaan);

        projectfuzzy.RunFuzzy();
    }

    //variabel
    Suhu suhu;
    Kebisingan kebisingan;
    Pencahayaan pencahayaan;
    Produk produk;

    double kondisi_suhu;
    double kondisi_kebisingan;
    double kondisi_pencahayaan;

    double u_suhu_rendah;
    double u_suhu_normal;
    double u_suhu_tinggi;

    double u_kebisingan_tenang;
    double u_kebisingan_agakbising;
    double u_kebisingan_bising;

    double u_pencahayaan_redup;
    double u_pencahayaan_agakterang;
    double u_pencahayaan_terang;

    double[] u_output;

    double[] output_rule;

}
