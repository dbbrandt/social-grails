<a href="http://twitter.com/esmzone" target="_blank"><span class="twitterHeader">Twitter</span></a>
<div class="twitterWidget">
<script src="http://widgets.twimg.com/j/2/widget.js"></script>
<script>
new TWTR.Widget({
  version: 2,
  type: 'profile',
  rpp: 4,
  interval: 6000,
  width: 194,
  height: 356,
  theme: {
    shell: {
      background: '#ffffff',
      color: '#797979'
    },
    tweets: {
      background: '#ffffff',
      color: '#797979',
      links: '#f65e06'
    }
  },
  features: {
    scrollbar: false,
    loop: false,
    live: true,
    hashtags: true,
    timestamp: true,
    avatars: false,
    behavior: 'all'
  }
}).render().setUser('ESMZone').start();
</script>
</div>
