<div align="center">

<img src="https://dev.talken.in/assets/img/icons/rexrun.png" width="96" alt="Rex Run logo">

# Rex Run

**My first game. An endless runner inspired by Chrome Dino and Geometry Dash.**

[Project page](https://dev.talken.in/projects/rex-run.html) · [Download](https://github.com/Shashwat-Gupta57/Rex-Run/releases/latest) · [All my projects](https://dev.talken.in/#work)

**6,300+** lines of Java · **8** game classes · **∞** runs

</div>

---

<img src="https://dev.talken.in/assets/img/shots/rexrun-1.webp" alt="Title screen — his name is Rex" width="100%">
<p align="center"><sub>Title screen — his name is Rex</sub></p>

<img src="https://dev.talken.in/assets/img/shots/rexrun-3.webp" alt="Mid-run: score, lives and coins" width="100%">
<p align="center"><sub>Mid-run: score, lives and coins</sub></p>

<img src="https://dev.talken.in/assets/img/shots/rexrun-4.webp" alt="Dodging stone blocks and jump pillars" width="100%">
<p align="center"><sub>Dodging stone blocks and jump pillars</sub></p>

## About

The first game I ever built, right after the terminal stopped being enough. Rex Run borrows the simplicity of Chrome’s offline dinosaur and the rhythm of Geometry Dash — and then adds everything I wished those games had.

There’s an economy (collect coins, spend them in the shop), lives you can pick up mid-run, an avatar editor, settings and saved progress, all on a game loop I wrote myself.

## What it does

- **Endless running** — Stone blocks, pillars to jump and obstacles that never stop coming.
- **Coins & lives** — Collect coins and hearts as you run.
- **The shop** — Spend your coins.
- **Avatar editor** — Make Rex your own.
- **Saves** — Progress is saved between sessions.
- **Pause anytime** — Resume, shop, settings or exit from the pause menu.

## More screens

<img src="https://dev.talken.in/assets/img/shots/rexrun-2.webp" alt="Pause menu with the custom avatar" width="49%">

## Download & run

1. These apps need **Java 21 or newer**. If you don't have it, install it once with the [JRE Installer](https://github.com/Shashwat-Gupta57/JRE-Installer/releases/latest) — one click, no admin rights. Every app looks for Java in the place it installs to first, then in `JAVA_HOME`.
2. Download **`Rex-Run-1.0.0-windows.zip`** from the [latest release](https://github.com/Shashwat-Gupta57/Rex-Run/releases/latest).
3. Unzip it anywhere you can write to (Desktop, Documents…) and run **`Rex Run.exe`**.

The folders next to the exe (images, fonts, saves) are part of the app — keep them together.

## Run from source

Open the folder in **BlueJ** (it's a BlueJ project — `package.bluej`) and run `rexRun.main()`, or with any JDK 21+:

```bash
javac *.java
java rexRun
```

## Under the hood

| | |
|---|---|
| Engine | Hand-written game loop in Swing |
| Objects | Blocks, coins, lives, jump pillars as their own classes |
| Saves | Plain-text save file |

## License

[GPL-3.0](LICENSE) © Shashwat Gupta · Flex Studios

Made by [Shashwat Gupta](https://dev.talken.in/) — see more at **[dev.talken.in](https://dev.talken.in/)**.
