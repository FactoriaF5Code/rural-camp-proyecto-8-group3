import PersonIcon from '@mui/icons-material/Person';
import CollectionsBookmarkIcon from '@mui/icons-material/CollectionsBookmark';
import ToggleButton from "@mui/material/ToggleButton";
import ToggleButtonGroup from "@mui/material/ToggleButtonGroup";
import { useState } from "react";
import './Searcher.css'

export const VerticalToggleButtons= () => {
    const [view, setView] = useState("list");

  const handleChange = (event, nextView) => {
    setView(nextView);
  };

  return (
    <ToggleButtonGroup
      orientation="vertical"
      value={view}
      exclusive
      onChange={handleChange}
    >
      <ToggleButton value="book" aria-label="book" className="toogleButton">
        <CollectionsBookmarkIcon className='toogleIcon' />
      </ToggleButton>
      <ToggleButton value="user" aria-label="user" className="toogleButton">
        <PersonIcon className='toogleIcon' />
      </ToggleButton>
    </ToggleButtonGroup>
  );
}