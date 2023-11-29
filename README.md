# Spring Project
## Görev 1
Bu proje, basit bir Spring Boot uygulamasıdır. Kitapları yöneten basit bir CRUD (Create, Read, Update, Delete) işlevselliği sunmaktadır.

## Başlangıç

### Gereksinimler
- Java 8 veya üstü
- Maven
- Bir Java IDE (IntelliJ IDEA, Eclipse vb.)

### Proje İndirme
Proje dosyalarını bilgisayarınıza indirin veya terminal veya komut istemcisinde şu komutu kullanarak proje dizinine gidin:
```bash git clone <proje-repo-linki> ```
Uygulamayı Çalıştırma
Proje dizininde terminal veya komut istemcisine gidin ve aşağıdaki komutu kullanarak uygulamayı başlatın:

```bash mvn spring-boot:run ```


Uygulama başladıktan sonra, tarayıcınızdan http://localhost:8009 adresine giderek uygulamayı görebilirsiniz.

### Örnek Veritabanı Kayıtları
Uygulama başlatıldığında, CommandLineRunner tarafından önceden tanımlanmış bazı örnek kitap kayıtları eklenir.

### Kullanım
Uygulama başlatıldıktan sonra, aşağıdaki endpoint'leri kullanarak kitaplar üzerinde CRUD işlemleri gerçekleştirebilirsiniz:

#### Ana Sayfa: 
http://localhost:8009/
#### Tüm Kitapları Listele: 
http://localhost:8009/books
#### Belirli Bir Kitabı Görüntüle: 
http://localhost:8009/get/{id}
#### Kitap Ekleme: 
http://localhost:8009/create (POST)
#### Kitap Güncelleme: 
http://localhost:8009/update/{id} (PUT)
#### Kitap Silme: 
http://localhost:8009/delete/{id} (DELETE)
####
Her bir endpoint'in nasıl kullanılacağı hakkında daha fazla bilgiyi ilgili Controller sınıfında bulabilirsiniz.
####
## Görev 2
## Güvenlik Konfigürasyonu
Bu proje, Spring Security ile güvenlik sağlamaktadır.  Güvenlik konfigürasyonu, temel yetkilendirme ve OAuth 2.0 ile giriş konfigürasyonunu içermektedir. GitHub sayesinde yapılmaktadır.
Bu konfigürasyon, ana sayfa ve favicon'a herkesin erişimine izin verirken, diğer tüm istekler için kimlik doğrulama gerektirir. Ayrıca, OAuth 2.0 ile giriş ve form tabanlı giriş konfigürasyonlarını içermektedir.

### @Configuration ve @EnableWebSecurity Annotasyonları:

#### @Configuration: 
Bu anotasyon, sınıfın bir konfigürasyon sınıfı olduğunu belirtir. Bu sınıf, Spring Security konfigürasyonunu içerir.
@EnableWebSecurity: Bu anotasyon, Spring Security'nin web güvenliğini etkinleştirir.
#### SecurityFilterChain Bean'i:

Bu metodun amacı, temel bir SecurityFilterChain oluşturmak ve HTTP güvenliği için temel yapıyı sağlamaktır.
SecurityFilterChain, uygulamanın güvenlik konfigürasyonunu tanımlayan ana bileşendir.
authorizeHttpRequests Bölümü:

#### .authorizeHttpRequests bölümü: 
hangi URL'lere kimin erişebileceğini belirler.
#### auth.requestMatchers("/").permitAll() : 
Ana sayfaya herkesin erişimine izin verir.
#### auth.requestMatchers("/favicon.ico").permitAll() : 
Favicon'a herkesin erişimine izin verir.
#### auth.anyRequest().authenticated() : 
Diğer tüm istekler için kimlik doğrulama gerektirir.
### oauth2Login ve formLogin Bölümleri:

#### .oauth2Login(withDefaults()): 
OAuth 2.0 ile giriş konfigürasyonunu sağlar.
#### .formLogin(withDefaults()): 
Form tabanlı giriş konfigürasyonunu sağlar.
### build Metodu:
build() metodu, tüm yapıyı oluşturur ve ayarları uygular.

## Görev 3
## Spring Boot ve gRPC
Bu görevde öncelikle book.proto dosyalarını ve pom.xml de değişikleri halledip BookServiceGrpc adlı bir dosyanın oluşmasını sağladım .
####
Bu service book.proto da yazdığım kodalrın bana server-client tarafında kullanmama yardımcı olacaktı.Fakat yeterli zamanımın kalmamasından dolayı yaptığım değişiklikleri geri aldım.
####
Bu projenin bu kısmını tamamlayamamış olsam bile bu konu hakkında öğrendiğim bilgiler benim için çok faydalı oldu.
#### gRPC (gRPC Remote Procedure Call), 
Sunucu ve istemci arasında etkileşimi kolaylaştırmak için kullanılan bir uzak prosedür çağrı (RPC) çerçevesidir. Protocol Buffers (Protobuf) adı verilen bir seri hizmet tanımı dilini kullanarak çalışır.
#### Protobuf Tanımları:
kitap.proto gibi bir Protobuf dosyası oluşturun. Bu dosya, kitap işlemleri için servis ve mesaj tanımlarını içermelidir. Örneğin, Kitap, KitapListesi, KitapEkleme, KitapGuncelleme, KitapSilme gibi mesajlar ve bu mesajları kullanacak bir servis tanımlayın.
#### gRPC Servisi Oluşturma:
Protobuf dosyasını kullanarak bir gRPC servisi oluşturmalıyız. Bu servis, kitap ekleme, güncelleme, silme ve listeleme işlevlerini içermelidir.


