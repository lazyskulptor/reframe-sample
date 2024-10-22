/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./resources/public/**/*.{html,js}"],
  theme: {
    screens: {
      sm: { max: "639px" },

      md: { max: "767px" },

      lg: { max: "1023px" },

      xl: { max: "1279px" },
    },
    extend: {},
  },
  plugins: [],
}

