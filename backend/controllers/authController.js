const User = require("../models/User");
const jwt = require("jsonwebtoken");

// Generate Access Token
const generateAccessToken = (user) => {
  return jwt.sign({ id: user._id, role: user.role }, process.env.JWT_SECRET, {
    expiresIn: "15m",
  });
};

// Generate Refresh Token
const generateRefreshToken = (user) => {
  return jwt.sign({ id: user._id }, process.env.JWT_REFRESH_SECRET, {
    expiresIn: "7d",
  });
};

// ✅ SIGNUP (no role)
const signupUser = async (req, res) => {
  const { name, email, password } = req.body; // removed role

  try {
    const userExists = await User.findOne({ email });
    if (userExists) return res.status(400).json({ message: "User already exists" });

    const user = new User({ name, email, password }); // no role set
    await user.save();

    const accessToken = generateAccessToken(user);
    const refreshToken = generateRefreshToken(user);

    res.cookie("refreshToken", refreshToken, {
      httpOnly: true,
      sameSite: "strict",
      secure: false,
      maxAge: 7 * 24 * 60 * 60 * 1000,
    });

    res.status(201).json({
      id: user._id,
      name: user.name,
      email: user.email,
      role: user.role,
      accessToken,
    });
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
};

// ✅ SELECT ROLE after signup
const selectUserRole = async (req, res) => {
  const { role } = req.body;
  const userId = req.user.id;

  if (!["student", "instructor"].includes(role)) {
    return res.status(400).json({ message: "Invalid role selected" });
  }

  try {
    const user = await User.findById(userId);
    if (!user) return res.status(404).json({ message: "User not found" });

    user.role = role;
    await user.save();

    res.status(200).json({ message: "Role assigned", role });
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
};

// LOGIN (unchanged)
const loginUser = async (req, res) => {
  const { email, password } = req.body;

  try {
    const user = await User.findOne({ email });
    if (!user || !(await user.matchPassword(password))) {
      return res.status(400).json({ message: "Invalid email or password" });
    }

    const accessToken = generateAccessToken(user);
    const refreshToken = generateRefreshToken(user);

    res.cookie("refreshToken", refreshToken, {
      httpOnly: true,
      sameSite: "strict",
      secure: false,
      maxAge: 7 * 24 * 60 * 60 * 1000,
    });

    res.json({
      id: user._id,
      name: user.name,
      email: user.email,
      role: user.role,
      accessToken,
    });
  } catch (error) {
    res.status(500).json({ message: error.message });
  }
};

// LOGOUT (unchanged)
const logoutUser = (req, res) => {
  res.clearCookie("refreshToken", {
    httpOnly: true,
    sameSite: "strict",
    secure: false,
  });
  res.status(200).json({ message: "Logged out successfully" });
};

// REFRESH TOKEN (unchanged)
const refreshToken = async (req, res) => {
  const token = req.cookies.refreshToken;
  if (!token) return res.status(401).json({ message: "No refresh token provided" });

  try {
    const decoded = jwt.verify(token, process.env.JWT_REFRESH_SECRET);
    const user = await User.findById(decoded.id);
    if (!user) return res.status(401).json({ message: "Invalid refresh token" });

    const newAccessToken = generateAccessToken(user);
    res.json({ accessToken: newAccessToken });
  } catch (err) {
    res.status(403).json({ message: "Invalid or expired refresh token" });
  }
};

module.exports = {
  signupUser,
  loginUser,
  logoutUser,
  refreshToken,
  selectUserRole, // ✅ export new controller
};
