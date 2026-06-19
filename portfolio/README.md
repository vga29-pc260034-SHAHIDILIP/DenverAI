# 🎨 Dilip Shahi's Portfolio Website

A modern, responsive portfolio website showcasing **Denver AI** project and freelance services in AI development, Java, and automation.

## 🚀 Features

- **Modern Design** - Dark theme with orange accent colors
- **Responsive Layout** - Works perfectly on mobile, tablet, and desktop
- **Fast Performance** - Built with React for optimal speed
- **Easy Navigation** - Smooth scrolling and intuitive navigation
- **Project Showcase** - Featured projects with tech stack
- **Services Section** - Highlight freelance offerings
- **Contact Form** - Easy way to get in touch
- **Social Links** - Connected to GitHub, LinkedIn, Twitter

## 📁 Project Structure

```
portfolio/
├── public/
│   └── index.html              # Main HTML file
├── src/
│   ├── components/
│   │   ├── Navbar.jsx         # Navigation bar
│   │   ├── Navbar.css
│   │   ├── Hero.jsx           # Hero section with intro
│   │   ├── Hero.css
│   │   ├── Projects.jsx       # Featured projects
│   │   ├── Projects.css
│   │   ├── Services.jsx       # Services offered
│   │   ├── Services.css
│   │   ├── Contact.jsx        # Contact form
│   │   ├── Contact.css
│   │   ├── Footer.jsx         # Footer
│   │   └── Footer.css
│   ├── App.jsx                # Main app component
│   ├── App.css                # App styles
│   ├── index.js               # React entry point
│   └── index.css              # Global styles
├── package.json               # Dependencies
└── README.md                  # This file
```

## 🛠️ Technologies Used

- **React 18** - Frontend framework
- **CSS3** - Modern styling with gradients and animations
- **React Icons** - Beautiful icon library
- **Responsive Design** - Mobile-first approach

## 📦 Installation & Setup

### Prerequisites
- Node.js (v14+)
- npm or yarn

### Steps

1. **Navigate to portfolio directory**
   ```bash
   cd portfolio
   ```

2. **Install dependencies**
   ```bash
   npm install
   ```

3. **Start development server**
   ```bash
   npm start
   ```
   The site will open at `http://localhost:3000`

4. **Build for production**
   ```bash
   npm build
   ```

## 🌐 Deployment

### GitHub Pages
```bash
npm install gh-pages --save-dev
```

Update `package.json`:
```json
"homepage": "https://vga29-pc260034-SHAHIDILIP.github.io/DenverAI/portfolio",
"scripts": {
  "predeploy": "npm run build",
  "deploy": "gh-pages -d build"
}
```

Deploy:
```bash
npm run deploy
```

### Vercel
1. Push to GitHub
2. Connect repo to Vercel
3. Set build directory to `portfolio`
4. Deploy!

### Netlify
1. Connect GitHub repo
2. Build command: `npm run build`
3. Publish directory: `build`
4. Deploy!

## 📝 Customization

### Update Personal Info
Edit `src/components/Navbar.jsx`, `Hero.jsx`, and `Footer.jsx` with your information.

### Change Colors
Modify color values in CSS files. Main colors:
- Primary Orange: `#ff6b35`
- Light Orange: `#ff8c42`
- Dark Background: `#0f0f0f`
- Light Text: `#e0e0e0`

### Add Projects
Edit the `projects` array in `src/components/Projects.jsx`

### Update Services
Edit the `services` array in `src/components/Services.jsx`

## 📞 Contact Section

The contact form is ready for integration with:
- **EmailJS** - Send emails directly
- **Formspree** - Simple form backend
- **Your own backend** - Custom solution

## 🔗 Links

- **GitHub**: https://github.com/vga29-pc260034-SHAHIDILIP
- **Denver AI Project**: https://github.com/vga29-pc260034-SHAHIDILIP/DenverAI

## 📄 License

This project is open source and available under the MIT License.

## 💡 Tips

- Update social media links in `Navbar.jsx` and `Footer.jsx`
- Add your actual email/phone in `Contact.jsx`
- Replace placeholder images with your actual screenshots
- Test on mobile devices before deploying
- Use Google Analytics for tracking

---

**Made with ❤️ using React** - Showcasing Denver AI and freelance services
