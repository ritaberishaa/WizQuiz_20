# WizQuiz - Aplikacion Android

WizQuiz është një aplikacion i thjeshtë quiz për Android që u ofron përdoruesve një seri pyetjesh quiz. Përdoruesit mund të regjistrohen, të identifikohen dhe të shikojnë informacionin e profilit të tyre. Ky projekt përdor Android Studio, SQLite për ruajtjen lokale dhe BCrypt për kriptimin e fjalëkalimeve.

## Karakteristikat

- **Regjistrimi dhe Identifikimi i Përdoruesve**:
  - Përdoruesit mund të regjistrohen me email, fjalëkalim dhe emër.
  - Fjalëkalimet ruhen në mënyrë të sigurt duke përdorur librarin BCrypt.
  - Përdoruesit mund të identifikohen duke përdorur kredencialet e tyre.

- **Aktiviteti Kryesor**:
  - Tregon një ekran interaktiv të aplikacionit me mundësi për përdoruesit që të ndërveprojnë me funksionalitetet e aplikacionit.
  - Një ikonë profili që çon në aktivitetin e profilit.

- **Aktiviteti i Profilit**:
  - Tregon informacionin e përdoruesit, përfshirë emrin e tij.
  - Të dhënat e përdoruesit merren nga baza e të dhënave SQLite.

- **Ndërveprimi me Bazen e të Dhënave**:
  - Përdor SQLite për ruajtjen e të dhënave lokale për menaxhimin e llogarive të përdoruesve dhe autentifikimin.
  - Ruajtja e detajeve të përdoruesve si email, emri dhe fjalëkalimi i kriptuar.

## Teknologjitë e Përdorura

- **Android**: Zhvilluar me Android Studio dhe Java.
- **SQLite**: Ruajtje lokale e të dhënave për menaxhimin e përdoruesve.
- **BCrypt**: Përdoret për kriptimin e fjalëkalimeve.
- **XML**: Përdorur për definimin e pamjeve të UI.
- **Java**: Për logjikën kryesore të aplikacionit, duke përfshirë ndërveprimin me bazën e të dhënave dhe menaxhimin e aktiviteteve.

## Përgatitja

Për të filluar projektin lokal, ndiqni këto hapa:

### Kushtet e Parapara

Sigurohuni që keni të instaluar:

- [Android Studio](https://developer.android.com/studio) (versioni më i fundit)
- Java Development Kit (JDK 11 ose më i lartë)
- Android SDK

### Klononi Depo-në

Klononi repo-në në makinën tuaj lokale duke përdorur komandën e mëposhtme:

```bash
git clone https://github.com/ritaberishaa/wizquiz.git
