`-*- mode: markdown; mode: visual-line; mode: adaptive-wrap-prefix; -*-`

# SIMPLE TEMPLATE

Simple template expansion.

- We attempt to lift out a URL substring using the decorator form `@app.route('/index/<name>')`
- We render a template with a positional parameter `title`, bound to the function argument `name` - if this is absent, use the string `"default"`
- The template `index.html` simply expands `title`
