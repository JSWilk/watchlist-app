import { useEffect, useState } from 'react';

const API_BASE = 'http://localhost:8080/api/watchlists';

function WatchlistList() {
  const [watchlists, setWatchlists] = useState([]);

  useEffect(() => {
    fetch(API_BASE)
      .then((res) => res.json())
      .then(setWatchlists)
      .catch(() => setWatchlists([]));
  }, []);

  return (
    <ul>
      {watchlists.map((watchlist) => (
        <li key={watchlist.id}>{watchlist.name}</li>
      ))}
    </ul>
  );
}

export default WatchlistList;
