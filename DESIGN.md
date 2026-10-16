# Gurukul: A Cultivation Sim from the Source — Extensive Design Doc

**Source:** ACS1 Wiki (fandom) + Office Hours design session
**Date:** 2026-10-16
**Branch:** main
**Status:** Design locked — ACS1 systems researched, Indian re-map complete, V1 scope defined (D1–D3 applied: Google Play primary, one-time purchase $12.99; yantra rules locked before CI/build; genuine karma/dharma mechanics)

---

## 1. One-Liner

A gurukul tycoon where you recruit disciples (shishya), match them to a path (yoga / tantra / veda / bhakti / jnana), train them through **finger-drawn yantra mandalas** (your cultivation + combat input), and the ones you perfect to the top of the chakra ladder **leave you for Moksha** — your best students ascend and are gone, and you recruit again. The gurukul is the base; the yantra-drawing is the "whoa"; the guru–shishya arc is the story frame.

---

## 2. ACS1 System Inventory (from Wiki Research)

This section catalogs every ACS1 system we researched from the Fandom wiki. Each entry notes the ACS1 mechanic and its function, serving as the reference for the Indian re-map in Section 3.

### 2.1 Game Modes

| ACS1 Mode | Function |
|---|---|
| Tutorial | Story-driven prologue; must complete to unlock other modes |
| Classic | Main free-play mode; customizable difficulty and starting conditions |
| Immortal (Ironman) | Hardcore: max difficulty, no manual save, fixed autosave, no tips |
| Illusory Realm | Sandbox/creative: test base layouts, fiddle with weather, no survival pressure |

### 2.2 Disciples (Shishyas)

**Two castes:**
- **Outer disciples** — mortals, main workforce, need food/water/sleep, can die easily, no Qi barrier
- **Inner disciples** — cultivators post-Dao foundation, focus on training/refinement/exploration, Qi barrier protects them

**Attributes (5 main + 1 special, capped at 10):**
- Perception — field of vision, fine-work task efficiency
- Constitution — lifespan, heat/cold resistance, strength-task efficiency
- Charisma — temperament, persuasion, friend-making, sect master performance
- Intelligence — skill learning speed, cultivation efficiency
- Luck — RNG success rate, breakthrough bottleneck odds
- Potential — Dao foundation build speed (min-max stat)

**Skills (3 categories):**
- Manual labor (Constitution-influenced): Mining, Farming, Construction, Crafting
- Fine skills (Perception/Charisma-influenced): Social, Artisanry, Cooking, Medicine
- Cultivation talents (immediate post-promotion): Battle, Qi Sense, Magic, Magic Crafting

### 2.3 Cultivation System

**Three Cultivation Methods:**
- **Xiandao** — learn Manuals from Manual Pavilions, craft Artifacts, practice Alchemy
- **Shendao** — gather Followers, build Divine Realm
- **Physical** — Remold body using Essences from breathing (meditation) and devouring items

**Cultivation Loop:**
1. Disciple cultivates → gains cultivation experience + inspiration points
2. Experience accumulates until breakthrough bottleneck
3. Breakthrough attempt → success = new realm, failure = regression/stasis
4. Inspiration points spent on manuals/skills (cost scales with Attainment)
5. Three cultivation modes: cultivate (experience), mind (mental state), practice (inspiration)
6. Mental state affects cultivation speed; keep above 60

**Breakthrough Realms (ACS1 → Indian re-map):**
| ACS1 Realm | Function | Indian Re-map |
|---|---|---|
| Qi Condensation | First cultivator stage | Chakra Opening: Mula |
| Foundation Establishment | Solidify cultivation | Chakra Opening: Svadhisthana |
| Core Formation | Critical stage, rebirth possible | Chakra Opening: Manipura |
| Golden Core | Score determines max Qi + next breakthrough difficulty | Chakra Opening: Anahata |
| Primordial Spirit | Sub-spirits, secret moves, elixirs | Chakra Opening: Vishuddha |
| Demigod | Camp anywhere, enter locations freely | Chakra Opening: Ajna |
| Immortality | Ascension / Moksha | Chakra Opening: Sahasrara → Moksha |

**Breakthrough Mechanics (ACS1 → Indian):**

| ACS1 Mechanic | Detail | Indian Re-map |
|---|---|---|
| Bottleneck | Halts experience gain until breakthrough succeeds | Chakra block — no prana gain until opened |
| Breakthrough duration | Varies per breakthrough (50s–1200s) | Sadhana timer duration |
| Success chance | Evaluated at END of duration (not start) | Chakra opening validated at sadhana end |
| Base success chance | Breakthrough-specific + attribute bonus | Path-specific + samskara/gift bonus |
| Fail bonus | Extra base chance per previous failure | Accumulated tapas from prior attempts |
| Mental State | Multiplies success chance (keep >60) | Sattva level multiplier |
| Luck | Multiplies success chance | Karma bonus |
| Sect Feng Shui | Adds bonus to success chance | Ashram Vastu alignment bonus |
| Weather / Season / Yin-Yang | Adds bonus to success chance | Kala (time) / Ritu (season) alignment |
| Qi on breakthrough tile | Adds bonus to success chance | Prana density at sadhana spot |
| Element Composition | Adds bonus to success chance | Bija-yantra elemental match |
| Golden Core Tier | Multiplies success chance (Golden Core+) | Anahata quality multiplier |
| Failure risk | Injuries, lifespan loss, regression | Vikriti (temptation), adharma, prana loss |
| Rebirth | Resets cultivation, preserves some progress | Punar-janma (reincarnation) |

**Breakthrough Types:**
- **Common** — Click breakthrough button at location of choice; standard chakra opening
- **Adventure** — Triggered during world exploration (kshetra-yatra)
- **Tribulation** — Pralaya trial at attainment/lifespan limits
- **Void** — Advanced breakthrough variant
- **Golden Core** — Critical stage; score determines max prana + next breakthrough difficulty
- **Talisman Drawing** — Yantra-drawing based breakthrough
- **Mental State** — Sattva-gated breakthrough
- **Shendao** — Divine realm breakthrough (follower/faith based)
- **Physical** — Body remolding breakthrough

### 2.3.5 Laws (Sutras) — Cultivation Paths

**Laws are permanent cultivation paths** chosen when an outer disciple is promoted to inner. Cannot be changed except via Rebirth (Punar-janma).

**ACS1 Law Matching → Indian:** Each path (yoga/tantra/veda/bhakti/jnana) requires attribute alignment (PER/CON/CHA/INT/LUK). Poor match severely reduces breakthrough success; overqualification grants Anahata (Golden Core) benefits.

**Five Taiyi Laws (ACS1) → Indian Paths:**
| ACS1 Law | Element | Path Match (PER/CON/CHA/INT/LUK) | Indian Path |
|---|---|---|---|
| Grand Chariot Wisdom | Metal | 7/4/5/-/- | Jnana (knowledge/insight) |
| Six Paths Reincarnation | Wood | 4/6/6/3/- | Bhakti (devotion) |
| Sixteen Supreme Steps | Water | 7/5/6/-/- | Yoga (meditation) |
| True Sun Refining | Fire | 5/5/5/5/5 | Tantra (ritual/yantra) |
| Sunflower Refining | Earth | 6/6/6/-/- | Veda (scholarship) |

**Non-Taiyi Laws:** From other sects/domains; obtained via Manifesting Mandate secrets, Kunlun Competition, or force-take from rival sects.

**Shendao Laws:** Use Divinity + Faith → Indian: Shendara path (follower-based, divine realm)

**Physical Laws:** Use body remolding → Indian: Kaya-sadhana path (essence/breath)

**Unorthodox Laws:** Randomly generated; max 1/4 Orthodox Attainment; transcribe into Veda Granthagara only.

### 2.4 Base Building (Gurukul / Ashram)

**Construction:** Square tile-based system. Build menu categories:
- Blueprint, Area, Pet, Flooring, Leisure, Wonder, Decoration, Sect, Work, Life, Structure

**Feng Shui (Five Elements):** Wood feeds Fire, Fire feeds Earth, Earth feeds Metal, Metal feeds Water, Water feeds Wood. Each element suppresses another. Room element = flooring + qi gather items. Cultivation room needs cushion + stands with qi gather items.

**Qi Gathering:** Items with Qi gathering attribute increase Qi in radius (n-1). Spirit soil patches provide rich Qi naturally.

**Needs System:**
- Water → Well
- Food → Bonfire → Dried Meat; Stove for cooked food
- Energy → Beds for Sleep (outers share, inners need private rooms)

**Buildings (ACS1 → Indian re-map):**
| ACS1 Building | Function | Indian Re-map |
|---|---|---|
| Cultivation Room | Cultivation environment | Yoga Shala / Sadhana Kshetra |
| Well | Water source | Pushkarini (sacred pond) |
| Bonfire / Stove | Food preparation | Agni Kunda (sacred fire) |
| Bed | Sleep / Energy | Shayana Griha (rest house) |
| Handcraft Table | Crafting | Karma Kuti (workshop) |
| Crafting Table | Artifact crafting | Yantra Vedika (yantra altar) |
| Manual Pavilion | Learn manuals | Veda Granthagara (library) |
| Qi gather items | Boost Qi in radius | Yantra stones / Bija tiles |

### 2.5 Artifacts, Alchemy, Items

**Artifact Crafting:**
- Any item can be refined into an artifact (costs Qi)
- Different base items → different artifact effects
- Success chance based on artifact crafting skill + mental state
- Cultivator feeds artifact (element affinity: fire cultivator feeds earth artifact)
- Equip treasure + weapon to prevent mood penalties

**Alchemy (Xiandao):**
- Pills/elixirs with tiers (e.g., Forming Pill, Nirvana Pill, Panacea Pill)
- Used for breakthroughs, healing, attribute boosts

**Talismans & Relics:**
- Persistent crafted items with effects
- Feng Shui relics provide environmental bonuses

**Mini-Universe:**
- Wonder unlocked via Secret Codex of Taiyi (Golden Core+)
- Storage device; contains items via elemental forces

### 2.6 World System

**Structure:** Regions → Locations. Each main region has a sect. Player starts at Ruins of Taiyi (their sect).

**World Map Interactions:**
- **Camp and Enter:** Assign inner disciple to area; trigger adventures after 4.8h then every 2-4 days; increase exploration; enter location (requires camping or Demigod)
- **Adventure:** Gather resources, trigger secrets/location adventures, luck-based loot, cultivation locations
- **Sect Leader:** Visit, gift, trade with other sects
- **Agency:** Cities and Districts; assign/manage agencies for trade and influence

**Main Regions (12+):** Mt. Sunshade, Mt. Kunlun, Heavenstep Peak, Mt. Lucian, Mt. Tiger Paw, Mt. Shu, Mt. Nelumbo, Mt. Hundred Insects, Mt. Pitfall, Mt. Blackstone, Exultant Isle, plus districts and cities.

**Indian Re-map (Kshetra-yatra):**
| ACS1 Region | Sect | Indian Re-map |
|---|---|---|
| Mt. Sunshade | Sunshade Abode | Kashi (Varanasi) — Shiva matha |
| Mt. Kunlun | Kunlun Palace | Rishikesh — yoga ashram |
| Heavenstep Peak | Skydome Palace | Badrinath — mountaintop tapasya |
| Mt. Lucian | Purple Cloud Temple | Puri — Jagannath bhakti matha |
| Mt. Tiger Paw | Mystic Unity Sect | Vrindavan — tantra sadhana |
| Mt. Shu | Blue Lotus Temple | Nalanda — veda scholarship |
| Mt. Nelumbo | Evenfall Abode | Bodh Gaya — jnana meditation |
| Mt. Hundred Insects | Mt. Hundred Insects | Kamakhya — shakta tantra |
| Mt. Pitfall | Pit of Doom | Varanasi smashana — cremation ground tapasya |
| Mt. Blackstone | Seven-Slaughtering Sect | Kalighat — kali upasana |
| Exultant Isle | Exultant Sect | Dwaraka — coastal matha |

### 2.7 Combat & Threats

- **Monsters / Beasts:** Wild animals attack outers; inner disciples can kill mortals in one slap
- **Yaoguai:** Demon disciples; face shapeshifting tribulations to stay "human"
- **Rival Sects:** Sect wars, raids, dungeon looting, forced trades
- **Heavenly Tribulation:** At attainment/lifespan limits; break through or suffer consequences
- **Qi Deviation:** Cultivation failure mode (introduced in v1.26 Heavenly Chaos update)

**Indian Re-map:**
| ACS1 Threat | Indian Re-map |
|---|---|
| Monsters/Beasts | Rakshasas, Asuras, Pisachas |
| Yaoguai | Rakshasa shishyas (need shapeshifting tribulation to remain in human form) |
| Rival Sects | Rival Mathas; Dharma-yuddha / Sthara-sanhita |
| Heavenly Tribulation | Pralaya Trial at each chakra opening |
| Qi Deviation | Vikriti (temptation/desire event) / Adharma regression |

### 2.8 Save System

- **Normal Save:** Manual save + autosave
- **Immortal Mode:** No manual save, fixed autosave intervals only

**Indian Re-map:** Standard save / Pralaya Lock (ironman — no manual save, fixed cosmic autosave)

---

## 3. ACS1 → Indian Mythology Re-Map (Complete)

Comprehensive re-map table covering every major ACS1 system:

| ACS1 System | ACS1 Function | Indian Re-map | Sanskrit Term |
|---|---|---|---|
| Sect | Colony/base management | Gurukul / Ashram | गुरुकुल / आश्रम |
| Disciple | Cultivator unit | Shishya | शिष्य |
| Outer Disciple | Mortal workforce | Antariya (outer grade) | अन्तरिय |
| Inner Disciple | Cultivator elite | Manasiya (inner grade) | मानसिय |
| Qi | Cultivation energy | Prana | प्राण |
| Qi Gathering | Radius-based Qi boost | Yantra stone placement | यन्त्र-स्थापना |
| Feng Shui | Element room layout | Vastu Shastra / Yantra geometry | वास्तु-शास्त्र |
| Cultivation Room | Training environment | Yoga Shala / Sadhana Kshetra | योग-शाला / साधना-क्षेत्र |
| Breakthrough | Realm ascension | Chakra Opening / Pralaya Trial | चक्र-उद्घाटन / प्रलय-परीक्षा |
| Heavenly Tribulation | Realm gate trial | Pralaya Trial | प्रलय-परीक्षा |
| Golden Core | Critical cultivation stage | Anahata Chakra Opening | अनाहात-चक्र |
| Primordial Spirit | Advanced cultivation | Vishuddha Chakra Opening | विशुद्ध-चक्र |
| Demigod | Free movement | Ajna Chakra Opening | आज्ञा-चक्र |
| Immortality / Ascension | End goal | Moksha (leave the game) | मोक्ष |
| Manual | Skill/knowledge | Sutra | सूत्र |
| Manual Pavilion | Learning building | Veda Granthagara | वेद-ग्रन्थागार |
| Artifact | Crafted persistent item | Yantra-Pratima / Dhara | यन्त्र-प्रतिमा / धारा |
| Alchemy | Pill crafting | Ankhikarman | आंखिकर्मन |
| Pill (Forming, Nirvana, etc.) | Consumable boost | Soma / Amrita tiers | सोम / अमृत |
| Talisman / Relic | Persistent effect item | Veda-Dhara / Stana relic | वेद-धारा / स्तान |
| World Region | Map area with sect | Kshetra (pilgrimage site) | क्षेत्र |
| Sect Leader Visit | Diplomacy/trade | Matha visit / Dharma-yuddha | मठ / धर्मयुद्ध |
| Agency | Trade/influence node | Matha branch / Sangha | मठ / संघ |
| Heavenly Chaos | World state shift | Yuga-drift | युग-द्रव |
| Karma / Condemnation | Sect alignment | Karma-Dharma / Paapa weight | कर्म-धर्म / पाप |
| Yaoguai | Demon disciple | Rakshasa shishya | राक्षस-शिष्य |
| Shapeshifting Tribulation | Yaoguai human-form trial | Rakshasa shuddhi trial | राक्षस-शुद्धि |
| Mini-Universe | Storage wonder | Pinda-anda (cosmic egg storage) | पिण्ड-अण्ड |
| Adventure | World location event | Kshetra-yatra event | क्षेत्र-यात्रा |
| Secret Codex | Unlocks Mini-Universe | Agama Tantra text | आगम-तन्त्र |
| Rebirth | Cultivation reset | Punar-janma (reincarnation) | पुनर्जन्म |
| Moodlet | Disciple disposition state | Guna state | गुण |
| Mental State | Cultivation speed modifier | Sattva level | सत्त्व |

**Karma / Dharma as tangible mechanics (genuine re-think, not terminology-only):**
- **Karma** is a signed accumulator (-100 to +100) on each shishya. Positive actions (refusing temptation, teaching others) add karma; negative actions (accepting vikriti, harming others) subtract karma. Karma gates breakthrough difficulty — high karma lowers the prana cost of chakra opening; low karma raises it and risks adharma regression.
- **Dharma** is the gurukul-level alignment tracker. Sect-wide decisions (temple construction, festival scheduling, rival matha relations) shift dharma. High dharma unlocks bonus chakra openings and prana regeneration; low dharma triggers yuga-drift events and slower training.
- These are **systemic**, not cosmetic labels — they feed into the breakthrough math table above (Karma bonus, Sattva multiplier, Adharma regression).

---

## 4. Gurukul Core Loop (V1)

1. **Recruit** — A shishya arrives (each with samskara disposition + natural gift).
2. **Match** — Assign to a path: Yoga / Tantra / Veda / Bhakti / Jnana.
3. **Train** — Shishya sits in sadhana (timer-based; one-time purchase skips nothing — no ads in V1). Player draws a yantra mandala to open the next chakra — the training + "combat" input, finger-traced sacred geometry with correct-rings validation. Gesture uses medium tolerance (±20px bounding box around guide nodes); wrong-ring deviation triggers an error state (-10% Prana, instant retry with no cooldown). Every stroke has full audio/haptic feedback (Singing bowl / tanpura tones, haptic pulses) per the Sensory Specifications in §Sensory. Upon breakthrough success, the player makes a binary Karma/Dharma choice (Karma = +15% Prana Speed / Dharma = +10% Aura Radius), locked for the upcoming 24-hour cycle.
4. **Temptations (Vikriti)** — World events: merchant, king, siren. Accept → sattva drops, karma drops, yantra dims. Refuse → progress continues, karma rises. Desire is the obstacle, not an enemy.
5. **Perfect** — Top of chakra ladder → shishya leaves for Moksha (screen fades to white). Attrition with dignity — recruit again.
6. **Grow Gurukul** — New rooms (Yoga Shala, Tantra Shala, Veda Granthagara, Ksetra field) = tycoon layer.

---

## 5. V1 Scope

- **Single-player, offline-capable, save-on-device** (Room/JSON to internal storage)
- **~40–80 screens** of content, one progression path to Moksha
- **Yantra-drawing input** as central training mechanic (finger-traced sacred geometry, correct-rings validation). Accessibility-first design: minimum 44dp touch targets on all interactive elements; canvas exposes dynamic `contentDescription` for screen readers (Idle / In-Progress / Error / Success states); WCAG AA contrast ratios (≥4.5:1 body text, ≥3:1 large display titles against `SlateBackground`); no hover-dependent affordances — every interaction reachable via tap or D-pad focus; every visual cue (wrong-ring crimson flash, breakthrough gold flare, path selection) is paired with distinct non-visual indicators (audio + haptic).
- **Distribution:** Google Play Store primary — **one-time purchase $12.99** (matches ACS1 mobile model). Cosmetic IAP may be added later (avatars, yantra skins, mandala patterns). No rewarded ads in V1.
- **No account system, no cross-server guilds, no PVP, no 100+ chapters** in V1
- **Social layer (post-Moksha "acharya" mode)** = V2, not V1
- **Standard save / Pralaya Lock (ironman)** save modes

---

## 6. Architecture (Engine-Agnostic)

```
┌───────────────────────────────────────────────────────────┐
│  GAMEPLAY CORE  (pure Kotlin, headless, no UI, no engine)  │
│  - state machines (shishya, chakra, yuga-drift)           │
│  - data tables (paths, yantras, sutras, relics, events)   │
│  - progression math (breakthrough formula, sattva/karma)  │
│  - save/load (Room or JSON)                               │
│  - fully unit-testable, zero platform deps                │
│  - event system for vikriti / temptation / karma hooks    │
└──────────────┬───────────────────────────┬───────────────┘
               │                           │
        ┌──────▼────────┐         ┌───────▼────────┐
        │ ANDROID RENDERER   │         │ (LATER) Godot  │
        │ Kotlin + Jetpack  │         │ renderer module  │
        │ Compose (V1 ship) │         │ wraps same core  │
        │ Touch input, yantra│         │ → Steam/desktop  │
        │ drawing canvas    │         │ optional, V2+    │
        └──────────────────┘         └──────────────────┘
```

- Core is pure Kotlin — no Android, no Godot, no Unity dependency. Owns all rules.
- Android first (V1): Kotlin + Jetpack Compose native app.
- Godot later (optional): renderer module consuming same pure-Kotlin core.
- **DI:** Koin or manual constructor injection for repository/data-layer boundaries.
- **Data layer:** Repository pattern wrapping Room/JSON save; event bus for karma/sattva/yuga-drift changes.
- **Design tokens:** Chakra-based color palette (Muladhara Red `#E53935`, Svadhisthana Orange `#FB8C00`, Manipura Yellow `#FDD835`, Anahata Green `#43A047`, Vishuddha Blue `#1E88E5`, Ajna Indigo `#5E35B1`, Sahasrara Violet `#7E57C2`, Karma Gold `#FFA000`, Dharma Sapphire `#1976D2`, Slate Background `#121212`, Ash Surface `#1E1E1E`); typography: Noto Serif (display headings) + Noto Sans / Inter (body & UI); component tokens: `{prana.meter}`, `{yantra.canvas}`, `{choice.button}`, `{status.bar}`.

---

## 6.5 Sensory Specifications (Audio / Haptic / Transitions / Edge Cases)

### Audio & Haptic Feedback Specs

| Event / Action | Audio Asset & Frequency | Haptic Pattern | Duration / Timing |
|---|---|---|---|
| Stroke Start / Active Tracing | Low continuous Tanpura hum (~108 Hz) | Gentle continuous micro-ticks | Active while finger is in contact with canvas |
| Wrong Ring / Error | Sharp dissonant brass bowl strike, fast decay | Single heavy thud (`LongPress` / Heavy Click) | ~300 ms audio decay; instant haptic pulse |
| Yantra Complete (Success) | Harmonious singing bowl sweep (432 Hz root → octave) | Triumphant double pulse (50 ms pulse, 30 ms pause, 80 ms pulse) | ~1200 ms audio ring-out |
| Path Selection (Karma/Dharma) | Soft brass chime / bell ping | Light click (`Confirm`) | ~200 ms audio ring-out |

### Screen Transitions & Motion Flow

```text
┌────────────────────────┐      Yantra Success      ┌────────────────────────┐
│  Screen 1: Sadhana     │  ────────────────────>   │ Screen 2: Breakthrough │
│  (Status + Canvas)     │   1.0s Crossfade + Flare │   (Streak + Path Choice)│
└────────────────────────┘                          └────────────────────────┘
            ▲                                                   │
            │               Select Path / Continue              │
            └───────────────────────────────────────────────────┘
                           Smooth Slide-Down (300ms)
```

- **Sadhana → Breakthrough:** Upon Yantra validation, the drawing trace flares white-gold (300 ms scale-up). Screen 1 subtly blurs and crossfades (1.0 s duration) into Screen 2 as the ascension title and streak counter animate into view with an upward spring curve (`FastOutSlowInEasing`).
- **Breakthrough → Next Cycle:** Selecting Karma/Dharma triggers a soft flash in the path's theme color (Gold / Sapphire), sliding Screen 2 smoothly down (300 ms) to return to the updated, calm Sadhana state ready for the next 24-hour incubation.

### Edge Case Handling Matrix

| Edge Case Scenario | Expected System Behavior | Data Preservation |
|---|---|---|
| Interrupted Stroke (Finger Lift / Incoming Call) | Incomplete stroke clears immediately. Canvas resets to Idle state without penalty. | Prana meter remains unchanged (100%). |
| Screen Rotation / Configuration Change | Lock orientation to Portrait-Only (`android:screenOrientation="portrait"`). | State persistence unaffected. |
| Battery Saver Mode Active | Disable particle shimmer animations and full-screen glow filters; maintain core vector trace, haptics, and audio. | Complete functional fallback with zero gameplay degradation. |
| App Backgrounded Mid-Gesture | Cancel active canvas gesture. On resume, reopen Screen 1 at full status with guide outline intact. | Prana state and streak data safely restored from local storage. |

---

## 7. Build / Ship Toolchain

- **Language:** Kotlin
- **App (V1):** Android native (Kotlin + Jetpack Compose)
- **CI:** GitHub Actions (build, test core + app, produce APK/AAB), with Gradle caching
- **Distribution:** Google Play Store primary (one-time purchase $12.99). Play signing key managed via Play App Signing.
- **Dev environment:** OpenCode (Kotlin-first)
- **Save:** Room (SQLite) or JSON to internal storage — offline, no account
- **Core testing:** JUnit/Kotest on headless core — progression math verifiable in CI before a pixel is drawn
- **Signing:** Play Store upload key + Play App Signing; keystore backed up securely, not committed

---

## 8. Open Questions (for next session)

All design decisions from the office-hours + plan-eng-review workflow are locked:

1. **[RESOLVED]** Yantra geometry: medium tolerance (±20px bounding box), wrong-ring = -10% Prana, instant retry with no cooldown. Bija-mantra → path mapping still to be defined in V2 authenticity pass.
2. **[RESOLVED]** Karma/Dharma as tangible mechanics: Karma Path (+15% Prana Speed, self-mastery) and Dharma Path (+10% Aura Radius, service/communal benefit), locked per 24-hour cycle, switchable at next breakthrough.
3. **[OPEN]** Core module layout + DI setup + first CI pipeline + Play Store signing key setup.
4. **[Team/V2]** Social / acharya-mode backend — accounts, leaderboards. Keep it fully out of V1.

---

## 9. Next Steps (in order)

1. **Lock yantra geometry rules** (chakra ring structure, wrong-ring failure → prana drop, bija-mantra→path mapping) — design + authenticity pass. **(Must complete before step 2 per D2 — no CI/build until gesture rules are frozen.)**
2. **Stand up repo + CI:** Kotlin core (headless) + Android app skeleton + GitHub Actions + Gradle caching + Play Store signing key setup. (First build)
3. **Build core state machines** + one full shishya recruit→Moksha loop, tested headlessly. (MVP)
4. **Add yantra-drawing input** in Android renderer; wire to core's chakra-opening. (The "whoa" — includes accessibility specs: 44dp touch targets, screen reader semantics, WCAG AA contrast; and full sensory specs: audio/haptic feedback, screen transitions, edge cases per Section 6.5.)
5. **Add cosmetic IAP** (Play Store) — optional, post-MVP
6. **Ship V1.** (Then V2: social/acharya layer, Godot/Steam renderer)

---

## 10. REA Usage Plan (when ACS APK available)

1. Point REA at ACS mobile APK to learn: mobile-optimization choices, touch-UI patterns, save-on-device scheme, what was cut from PC.
2. **Only** use findings to inform our own system design. **Never** lift code, assets, shaders, data-table layouts, or level formats.
3. Keep REA in reserve for deeper dives (exact breakthrough formula, sect-management tick cadence, karma math) when building each subsystem.

---

## Sources

- ACS1 Fandom Wiki: Beginner's Guide, Cultivation Methods, World, Build
- ACS1 Wikipedia / HandWiki entry
- GOG.com store page
- Games Press release
- Existing office-hours design doc (admin-unknown-design-20261015-134119.md) — merged and superseded
- Office-hours diagnostic session (startup mode, pre-product, D1-D4 premises resolved, Approach C selected)

---

## Visual Sketch (UI Ideas Only)

A rough wireframe was generated for Approach C (single-screen yantra breakthrough). It is intentionally rough — system fonts, gray borders, no color, inline CSS only. It shows two screens:

**Screen 1 — Sadhana (Daily Meditation):** Shishya (Arjun) in Padmasana, Prana meter at 100%, canvas for drawing the Shakti/Prana inverted triangle, "Confirm & Cast Yantra →" submission trigger (button acts as submit AFTER gesture, not replacement).

**Screen 2 — Breakthrough Complete:** "Ascended to Prana Seeker", Streak: Day 3, "Day 3 unlock: Solar Yantra shape available", Karma Path vs Dharma Path choice buttons, "Continue to Tomorrow →" button.

**Key flow:** Draw yantra on canvas → submit → see breakthrough result + make Karma/Dharma choice → continue to tomorrow. The choice appears AFTER the gesture, not alongside it (per user feedback on gesture-to-choice sequence).

Screenshot reference: `/var/folders/0w/fmpw5lvx5h91vpbxbmn4nzs40000gn/T//gstack-sketch.rG4OLr/sketch.png`

This sketch can be referenced by downstream skills (`/plan-design-review`, `/design-review`) to see what was originally envisioned.

---

## What I Noticed (Founder Signals)

Office-hours diagnostic (startup mode, pre-product, idea stage) surfaced **7 founder signals**:

| Signal | Evidence from session |
|---|---|
| Real problem | Zero direct validation for Gurukul or its yantra mechanic — demand is entirely a hypothesis |
| Named user | Vikram, 24-28, tech worker in urban India, 3:15 PM Tuesday micro-break trigger |
| Pushback on premises | Disagreed with all three premises (gesture as core hook, 15-second ritual retention, single-screen sufficiency) with detailed reasoning |
| Solves a real gap | Players split between East Asian cultivation games (rich mechanics, wrong mythology) and Indian mythology action games (right setting, shallow loops) |
| Domain expertise | Knows idle/retention mechanics — streak fatigue, static math destroying curiosity, gesture friction vs. reward ratio |
| Taste | Cares about gesture recognition tolerance, audio/haptic quality, avoiding cringe cultural representation |
| Agency | Provided 2-week execution plan, ASCII diagram, minimal technical scope |

**Read:** Vikram won't open Gurukul for a 15-second ritual in isolation. The gesture must be the tactile climax of a deeper idle progression loop with variable breakthrough results and visible idle growth. Theme (Indian mythology) is a top-of-funnel hook, not a product moat — mechanics must be fundamentally different from ACS1's East Asian sect-management loop.

---

## The Assignment

Build the single-screen yantra breakthrough prototype (Approach C: Enhanced Wedge) and verify 7-day retention:

1. **Build** the single Compose/Canvas screen with Shishya in Padmasana, one yantra (Shakti/Prana inverted triangle), idle Prana accumulation, gesture recognition with haptic/audio feedback, daily streak counter, and local JSON storage.
2. **Add** the binary Karma/Dharma choice after each breakthrough (Solar Prana vs Lunar Prana) and one unlock over time (new Yantra shape at Day 3).
3. **Test** — Open the app daily for 5 days. If you (or Vikram) draw the Yantra on Day 5 **without a push notification**, the hook is proven. If not, the gesture needs rework before any further screens are built.
4. **Do not** build the ashram, multi-disciple management, combat, or CI/CD until Day-5 retention is validated.

Success criteria: 5 consecutive days of unprompted Yantra drawing. Failure: gesture friction or streak fatigue by Day 3 → rework gesture tolerance or add variable breakthrough outcomes.

---

*REA note: We do not have the ACS APK locally. REA tools (rea_decode_android_resources, rea_inspect_android_package, etc.) work on local files only. When an ACS APK is placed at a known local path, run REA against it to validate the ACS1 system inventory above before finalizing yantra rules and breakthrough math.*

---

## What I Noticed (Founder Signals)

Office-hours diagnostic (startup mode, pre-product, idea stage) surfaced **7 founder signals**:

| Signal | Evidence from session |
|---|---|
| Real problem | Zero direct validation for Gurukul or its yantra mechanic — demand is entirely a hypothesis |
| Named user | Vikram, 24-28, tech worker in urban India, 3:15 PM Tuesday micro-break trigger |
| Pushback on premises | Disagreed with all three premises (gesture as core hook, 15-second ritual retention, single-screen sufficiency) with detailed reasoning |
| Solves a real gap | Players split between East Asian cultivation games (rich mechanics, wrong mythology) and Indian mythology action games (right setting, shallow loops) |
| Domain expertise | Knows idle/retention mechanics — streak fatigue, static math destroying curiosity, gesture friction vs. reward ratio |
| Taste | Cares about gesture recognition tolerance, audio/haptic quality, avoiding cringe cultural representation |
| Agency | Provided 2-week execution plan, ASCII diagram, minimal technical scope |

**Read:** Vikram won't open Gurukul for a 15-second ritual in isolation. The gesture must be the tactile climax of a deeper idle progression loop with variable breakthrough results and visible idle growth. Theme (Indian mythology) is a top-of-funnel hook, not a product moat — mechanics must be fundamentally different from ACS1's East Asian sect-management loop.

---

## The Assignment

Build the single-screen yantra breakthrough prototype (Approach C: Enhanced Wedge) and verify 7-day retention:

1. **Build** the single Compose/Canvas screen with Shishya in Padmasana, one yantra (Shakti/Prana inverted triangle), idle Prana accumulation, gesture recognition with haptic/audio feedback, daily streak counter, and local JSON storage.
2. **Add** the binary Karma/Dharma choice after each breakthrough (Solar Prana vs Lunar Prana) and one unlock over time (new Yantra shape at Day 3).
3. **Test** — Open the app daily for 5 days. If you (or Vikram) draw the Yantra on Day 5 **without a push notification**, the hook is proven. If not, the gesture needs rework before any further screens are built.
4. **Do not** build the ashram, multi-disciple management, combat, or CI/CD until Day-5 retention is validated.

Success criteria: 5 consecutive days of unprompted Yantra drawing. Failure: gesture friction or streak fatigue by Day 3 → rework gesture tolerance or add variable breakthrough outcomes.

---

## Sources

- ACS1 Fandom Wiki: Beginner's Guide, Cultivation Methods, World, Build
- ACS1 Wikipedia / HandWiki entry
- GOG.com store page
- Games Press release
- Existing office-hours design doc (admin-unknown-design-20261015-134119.md) — merged and superseded
- Office-hours diagnostic session (startup mode, pre-product, D1-D4 premises resolved, Approach C selected)

---

*REA note: We do not have the ACS APK locally. REA tools (rea_decode_android_resources, rea_inspect_android_package, etc.) work on local files only. When an ACS APK is placed at a known local path, run REA against it to validate the ACS1 system inventory above before finalizing yantra rules and breakthrough math.*