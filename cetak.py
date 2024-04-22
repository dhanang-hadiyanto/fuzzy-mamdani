import numpy as np
import skfuzzy as fuzz
from skfuzzy import control as ctrl

# Data rata-rata jumlah produk
rata_rata_product = [
    148.00, 150.90, 146.50, 143.10, 146.53,
    142.73, 136.73, 140.77, 135.97, 149.73,
    153.27, 152.13, 148.00, 150.63, 147.63,
    141.47, 145.67, 140.20, 142.10, 146.53,
    142.17, 138.70, 141.40, 138.30, 133.33,
    138.53, 133.77
]

# Fuzzifikasi
suhu = ctrl.Antecedent(np.arange(130, 161, 1), 'suhu')
suhu['rendah'] = fuzz.trimf(suhu.universe, [130, 130, 145])
suhu['normal'] = fuzz.trimf(suhu.universe, [140, 145, 155])
suhu['tinggi'] = fuzz.trimf(suhu.universe, [145, 160, 160])

kebisingan = ctrl.Antecedent(np.arange(130, 161, 1), 'kebisingan')
kebisingan['tenang'] = fuzz.trimf(kebisingan.universe, [130, 130, 145])
kebisingan['agak_bising'] = fuzz.trimf(kebisingan.universe, [140, 145, 155])
kebisingan['bising'] = fuzz.trimf(kebisingan.universe, [145, 160, 160])

pencahayaan = ctrl.Antecedent(np.arange(130, 161, 1), 'pencahayaan')
pencahayaan['redup'] = fuzz.trimf(pencahayaan.universe, [130, 130, 145])
pencahayaan['agak_terang'] = fuzz.trimf(pencahayaan.universe, [140, 145, 155])
pencahayaan['terang'] = fuzz.trimf(pencahayaan.universe, [145, 160, 160])

# Output
jumlah_produk = ctrl.Consequent(np.arange(130, 161, 1), 'jumlah_produk')
jumlah_produk['rendah'] = fuzz.trimf(jumlah_produk.universe, [130, 130, 145])
jumlah_produk['sedang'] = fuzz.trimf(jumlah_produk.universe, [140, 145, 155])
jumlah_produk['tinggi'] = fuzz.trimf(jumlah_produk.universe, [145, 160, 160])

# Pembentukan Aturan
rule1 = ctrl.Rule(suhu['rendah'] & kebisingan['tenang'] & pencahayaan['redup'], jumlah_produk['rendah'])
rule2 = ctrl.Rule(suhu['rendah'] & kebisingan['tenang'] & pencahayaan['agak_terang'], jumlah_produk['sedang'])
rule3 = ctrl.Rule(suhu['rendah'] & kebisingan['tenang'] & pencahayaan['terang'], jumlah_produk['tinggi'])
rule4 = ctrl.Rule(suhu['rendah'] & kebisingan['agak_bising'] & pencahayaan['redup'], jumlah_produk['rendah'])
rule5 = ctrl.Rule(suhu['rendah'] & kebisingan['agak_bising'] & pencahayaan['agak_terang'], jumlah_produk['sedang'])
rule6 = ctrl.Rule(suhu['rendah'] & kebisingan['agak_bising'] & pencahayaan['terang'], jumlah_produk['tinggi'])
rule7 = ctrl.Rule(suhu['rendah'] & kebisingan['bising'] & pencahayaan['redup'], jumlah_produk['rendah'])
rule8 = ctrl.Rule(suhu['rendah'] & kebisingan['bising'] & pencahayaan['agak_terang'], jumlah_produk['sedang'])
rule9 = ctrl.Rule(suhu['rendah'] & kebisingan['bising'] & pencahayaan['terang'], jumlah_produk['tinggi'])
rule10 = ctrl.Rule(suhu['normal'] & kebisingan['tenang'] & pencahayaan['redup'], jumlah_produk['rendah'])
rule11 = ctrl.Rule(suhu['normal'] & kebisingan['tenang'] & pencahayaan['agak_terang'], jumlah_produk['sedang'])
rule12 = ctrl.Rule(suhu['normal'] & kebisingan['tenang'] & pencahayaan['terang'], jumlah_produk['tinggi'])
rule13 = ctrl.Rule(suhu['normal'] & kebisingan['agak_bising'] & pencahayaan['redup'], jumlah_produk['rendah'])
rule14 = ctrl.Rule(suhu['normal'] & kebisingan['agak_bising'] & pencahayaan['agak_terang'], jumlah_produk['sedang'])
rule15 = ctrl.Rule(suhu['normal'] & kebisingan['agak_bising'] & pencahayaan['terang'], jumlah_produk['tinggi'])
rule16 = ctrl.Rule(suhu['normal'] & kebisingan['bising'] & pencahayaan['redup'], jumlah_produk['rendah'])
rule17 = ctrl.Rule(suhu['normal'] & kebisingan['bising'] & pencahayaan['agak_terang'], jumlah_produk['sedang'])
rule18 = ctrl.Rule(suhu['normal'] & kebisingan['bising'] & pencahayaan['terang'], jumlah_produk['tinggi'])
rule19 = ctrl.Rule(suhu['tinggi'] & kebisingan['tenang'] & pencahayaan['redup'], jumlah_produk['rendah'])
rule20 = ctrl.Rule(suhu['tinggi'] & kebisingan['tenang'] & pencahayaan['agak_terang'], jumlah_produk['sedang'])
rule21 = ctrl.Rule(suhu['tinggi'] & kebisingan['tenang'] & pencahayaan['terang'], jumlah_produk['tinggi'])
rule22 = ctrl.Rule(suhu['tinggi'] & kebisingan['agak_bising'] & pencahayaan['redup'], jumlah_produk['rendah'])
rule23 = ctrl.Rule(suhu['tinggi'] & kebisingan['agak_bising'] & pencahayaan['agak_terang'], jumlah_produk['sedang'])
rule24 = ctrl.Rule(suhu['tinggi'] & kebisingan['agak_bising'] & pencahayaan['terang'], jumlah_produk['tinggi'])
rule25 = ctrl.Rule(suhu['tinggi'] & kebisingan['bising'] & pencahayaan['redup'], jumlah_produk['rendah'])
rule26 = ctrl.Rule(suhu['tinggi'] & kebisingan['bising'] & pencahayaan['agak_terang'], jumlah_produk['sedang'])
rule27 = ctrl.Rule(suhu['tinggi'] & kebisingan['bising'] & pencahayaan['terang'], jumlah_produk['tinggi'])

# Buat sistem kontrol
produk_ctrl = ctrl.ControlSystem([
    rule1, rule2, rule3, rule4, rule5, rule6, rule7, rule8, rule9,
    rule10, rule11, rule12, rule13, rule14, rule15, rule16, rule17, rule18,
    rule19, rule20, rule21, rule22, rule23, rule24, rule25, rule26, rule27
])

# Buat simulasi
produksi_simulasi = ctrl.ControlSystemSimulation(produk_ctrl)

# Defuzzifikasi
hasil_defuzzifikasi = []

for value in rata_rata_product:
    produksi_simulasi.input['suhu'] = value
    produksi_simulasi.input['kebisingan'] = value
    produksi_simulasi.input['pencahayaan'] = value
    produksi_simulasi.compute()
    hasil_defuzzifikasi.append(produksi_simulasi.output['jumlah_produk'])

print("Hasil defuzzifikasi:")
for i, hasil in enumerate(hasil_defuzzifikasi):
    print("Data ke-", i+1, ": ", hasil)