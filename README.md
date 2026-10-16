# Gurukul: Cultivation Simulator

An open-source Android cultivation simulation game inspired by the mechanics of Amazing Cultivation Simulator, re-rooted in authentic Hindu mythology.

## What This Is

A gurukul tycoon where you:
- Recruit disciples (shishyas) with unique dispositions
- Match them to paths: Yoga, Tantra, Veda, Bhakti, Jnana
- Train them through finger-drawn yantra mandalas
- Face temptations (vikritis) that test their sattva
- The perfect disciples achieve Moksha and leave you

The core fantasy: **your best students succeed by leaving you.**

## Tech Stack

- **Language:** Kotlin (Multiplatform-ready core)
- **Engine:** Native Android (Compose) for V1
- **Architecture:** Engine-agnostic gameplay core + Android renderer
- **Monetization:** Rewarded ads + cosmetic IAP (no pay-to-win)
- **Distribution:** F-Droid primary, Play Store secondary

## Project Structure

```
.
├── core/           # Pure Kotlin headless core (no UI, no platform deps)
│   ├── src/commonMain/kotlin/
│   │   └── ... state machines, progression math, data tables
│   └── build.gradle.kts
├── app/            # Android renderer (Compose)
│   ├── src/main/kotlin/
│   │   └── ... UI, input, rendering
│   └── build.gradle.kts
└── .github/        # CI/CD for F-Droid builds
```

## Getting Started

Requires:
- JDK 17+ (Android development)
- Android SDK with API 33+
- Gradle 8+

Build:
```bash
./gradlew assembleDebug
```

Test core (headless):
```bash
./gradlew :core:jvmTest
```

## Design Philosophy

**Don't copy ACS.** The cultivation-sim genre's mentorship + asceticism + spiritual-progress core is actually Hindu in origin. We're returning the source with a yantra/chakra/bija system xianxia never had.

**Authentic, not exotic.** Deep Sanskrit research behind every system. This makes it defensible as "the Indian one" and respectful to the source tradition.

**Solo-dev friendly.** V1 is single-player, offline, save-on-device. Social layer (acharya mode) comes later.

## License

MIT Open Source — see LICENSE for details.

## Status

Brainstorm complete. Design doc locked. Building V1 skeleton now.
