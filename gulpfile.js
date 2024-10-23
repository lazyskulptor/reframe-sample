const { src, dest, task, watch, series } = require("gulp");
const sass = require("gulp-sass")(require("sass"));
const concat = require("gulp-concat");
const postcss = require("gulp-postcss");
const purgecss = require("gulp-purgecss");
const cleanCSS = require("gulp-clean-css");
// const logSymbols = require("log-symbols");

const options = {
  config: {
    "tailwindjs": "./tailwind.config.js"
  },
  paths: {
    src: {
      css: "./src/css",
    },
    dist: {
      css: "./resources/public/css",
      js: "./resources/public/js",
    },
    build: {
      css: "./target/css",
    }
  }
};



//Compiling styles
task("dev-styles", () => {
  var tailwindcss = require("tailwindcss");
  return src(options.paths.src.css + "/**/*")
    .pipe(sass().on("error", sass.logError))
    .pipe(
      postcss([
        tailwindcss(options.config.tailwindjs),
        require("autoprefixer"),
      ]),
    )
    .pipe(concat({ path: "style.css" }))
    .pipe(dest(options.paths.dist.css));
});

//Compiling styles
task("build-styles", () => {
  return src(options.paths.dist.css + "/**/*")
    .pipe(
      purgecss({
        content: ["src/views/**/*.html", "src/**/.*js"],
        defaultExtractor: (content) => content.match(/[A-Za-z0-9-_:/]+/g) || [],
      }),
    )
    .pipe(cleanCSS({ compatibility: "ie8" }))
    .pipe(dest(options.paths.build.css));
});

//Cleaning dist folder for fresh start
task("clean:dist", async () => {
  const del = await import("del");
  console.info("Cleaning dist folder for fresh start.\n");
  return del.deleteSync(options.paths.dist.css);
});

//Cleaning build folder for fresh start
task("clean:build", async () => {
  const del = await import("del");
  console.info("Cleaning build folder for fresh start.\n");
  return del.deleteSync(options.paths.build.css);
});

task("watch-changes", (done) => {
  watch(options.config.tailwindjs, series("dev-styles")); // configs

  watch(options.paths.dist.js + "/**/*.js", series("dev-styles")); // js

  watch(options.paths.src.css + "/**/*", series("dev-styles")); // css 

  console.info("Watching for Changes made to files.\n");

  done();
});

//series of tasks to run on dev command
task(
  "development",
  series(
    "clean:dist",
    "dev-styles",
    (done) => {
      console.log(
        // "\n\t" + logSymbols.info,
        "npm run dev is complete. Files are located at ./dist\n",
      );
      done();
    },
  ),
);

task(
  "optamizedBuild",
  series(
    "clean:build",
    // "dev-styles",
    // "build-styles",
    (done) => {
      console.log(
        // "\n\t" + logSymbols.info,
        "npm run build is complete. Files are located at ./build\n",
      );
      done();
    },
  ),
);

exports.default = series("development", "watch-changes");
exports.build = series("optamizedBuild");
