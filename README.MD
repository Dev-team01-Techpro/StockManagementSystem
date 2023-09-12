# Depo Projesi

Bu projede, bir fabrikada kullanılan bir depo sistemi olan Depo Uygulaması Java programlama dili kullanılarak gerçekleştirilecektir. Proje, aşağıdaki 3 sınıftan oluşacaktır:

## 1. PojoUrun Sınıfı

PojoUrun sınıfı aşağıdaki özelliklere sahip olacaktır:

- id
- urunIsmi
- uretici
- miktar
- birim
- raf

Bu sınıfın getter ve setter metotları bulunacaktır.

## 2. DepoSistemi Sınıfı

Bu sınıf, depo işlemlerinin gerçekleştirileceği metodları içerecektir. DepoSistemi sınıfında aşağıdaki metodlar yer alacaktır:

- `urunTanimlama()`: Bu metot, kullanıcıdan ürün adı, üretici ve birim bilgilerini alarak yeni bir ürün tanımlayacaktır. Her ürün için bir id oluşturulacak ve bu id ile birlikte ürün bilgileri bir Map veri yapısında saklanacaktır. Ürünün miktarı başlangıçta 0 olacak ve raf bilgisi "-" olarak atanacaktır.

- `urunListele()`: Bu metot, tanımlanan ürünleri listelemek için kullanılacaktır. Ürünlerin id, isim, üretici, miktar, birim ve raf bilgileri görüntülenecektir. Eğer ürünün miktarı veya raf bilgisi tanımlanmamışsa, varsayılan değerler kullanılacaktır.

- `urunGirisi()`: Bu metot, depoya ürün girişi yapmak için kullanılacaktır. Kullanıcıdan ürünün id numarası ve giriş miktarı alınacaktır. Bu bilgilere göre, ilgili ürünün miktarı güncellenecektir.

- `urunuRafaKoy()`: Bu metot, bir ürünü rafa yerleştirmek için kullanılacaktır. Kullanıcıdan ürünün id numarası ve raf bilgisi alınacaktır. İlgili ürün, verilen raf numarasına göre güncellenecektir.

- `urunCikisi()`: Bu metot, depodan ürün çıkışı yapmak için kullanılacaktır. Kullanıcıdan ürünün id numarası ve çıkış miktarı alınacaktır. Ürün miktarı güncellenecek ve eğer miktar 0'dan küçük olursa, sadece miktarın 0 olduğu görüntülenecektir. Ürün tanımı silinmeyecektir.

## 3. Runner Sınıfı

Bu sınıf, projenin çalıştırılmasını sağlayacak bir Runner sınıfıdır. Bu sınıf içinde DepoSistemi sınıfının nesnesi oluşturulacak ve ilgili metotlar çağrılacaktır.

## Proje Senaryosu

Aşağıda, projenin senaryosu ve örnek bir kullanımı verilmiştir:

```java
DepoSistemi depo = new DepoSistemi();

depo.urunTanimlama("1000", "Un", "Hekimoğlu", "Cuval");
depo.urunListele();

// Çıktı:
// id     ismi    ureticisi   miktari    birimi    raf
// --------------------------------------------------
// 1000   Un      Hekimoğlu   0          Cuval     -

depo.urunGirisi("1000", 5);
depo.urunListele();

// Çıktı:
// id     ismi    ureticisi   miktari    birimi    raf
// --------------------------------------------------
// 1000   Un      Hekimoğlu   5          Cuval     -

depo