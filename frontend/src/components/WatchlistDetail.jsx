function WatchlistDetail({ watchlist }) {
  if (!watchlist) return null;

  return (
    <div>
      <h2>{watchlist.name}</h2>
    </div>
  );
}

export default WatchlistDetail;
